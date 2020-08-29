package com.leetCode;

public class PrisonCellsAfterNDays {
    public static void main(String args[]){
        int[] cells = new int[]{1,0,0,1,0,0,1,0};
        int N = 1000000000;
        prisonAfterNDays(cells,N);
    }

    public static int[] prisonAfterNDays(int[] cells, int N){
        if(N > 14){
            N = N%14 + 14;
        }else{
            N = N%14;
        }
        for(int i = 0 ; i < N ; i++){
            int[] temp = new int[cells.length];
            temp[0] = 0;
            temp[cells.length-1] = 0;
            for(int j = 1 ; j < cells.length-1 ; j++){
                if(cells[j-1] == cells[j+1]){
                    temp[j] = 1;
                }else{
                    temp[j] = 0;
                }
            }
            cells = temp.clone();
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
