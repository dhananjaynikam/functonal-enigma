package com.leetCode;

/*
There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
 */
public class PrisonCellsAfterNDays {
    public static void main(String args[]){
        int[] cells = new int[]{1,0,0,1,0,0,1,0};
        int N = 1000000000;
        prisonAfterNDays(cells,N);
    }

    public static int[] prisonAfterNDays(int[] cells, int N){
        //The order repeats after 14 iterations this is because the prison is of 8 cells will change for other number.
        //The trick is to do calculations till only 14
        if(N > 14){
            N = N%14 + 14; //+14 indicates the number at which the answer will be
        }else{
            N = N%14;
        }
        for(int i = 0 ; i < N ; i++){
            int[] temp = new int[cells.length];
            temp[0] = 0;
            temp[cells.length-1] = 0;
            for(int j = 1 ; j < cells.length-1 ; j++){
                if(cells[j-1] == cells[j+1]){ //check the neighboring cells. if they are equal change the current cell
                    temp[j] = 1;
                }else{
                    temp[j] = 0;
                }
            }
            cells = temp.clone(); //maintain the changes as we have to work on this cell
            print(cells);
        }
        return cells;
    }

    public static void print(int[] cells){
        for(int a : cells){
            System.out.print(a);
        }
        System.out.print("\n");
    }
}
