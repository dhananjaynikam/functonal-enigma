package com.leetCode;

public class Learning {
    public static void main(String args[]){
        ultaAlgo();
    }

    public static void algo(){
        int s = 0;
        int [][] before = new int[][]{{2,3},{5,7}};
        int[][] after = new int[2][2];
        int x = 1;
        int y = 1;
        for (int i = 0; i <= x; ++i) {
            for (int j = 0; j <= y; ++j) {
                s = s + before[i][j];
            }
        }

        after[x][y] = s;
        System.out.println(s);
    }

    public static void ultaAlgo(){
        int s = 0;
        int [][] after = new int[][]{{1,2},{3,4}};
        int[][] before = new int[2][2];
        int x = 1;
        int y = 1;
        for (int i = 0; i <= x; ++i) {
            for (int j = 0; j <= y; ++j) {
                s =  after[i][j] - s;
            }
        }

        before[x][y] = s;
        System.out.println(s);
    }
}
