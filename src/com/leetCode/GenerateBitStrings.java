package com.leetCode;

public class GenerateBitStrings {
    static int[] A = new int[5];

    public static void main(String args[]){
        Binary(5);
    }

    public static void Binary(int n){
        if(n<1){
            for (int a: A
                 ) {
                System.out.print(a);
                System.out.print(" ");
            }
            System.out.println(" ");
        }else{
            A[n-1] = 0;
            Binary(n-1);
            A[n-1] = 1;
            Binary(n-1);
        }
    }
}
