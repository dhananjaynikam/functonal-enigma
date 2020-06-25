package com.leetCode;

public class FactorialTrailingZeros {
    public static void main(String args[]){
    System.out.print(trailingZeroes(30));
    }

    public static int trailingZeroes(int n){
        if(n<5)
            return 0;
        long x=5;
        long count=0;
        while(x<=n)
        {
            long q=n/x;
            count=count+q;
            x=x*5;
        }
        return (int)count;
    }
}
