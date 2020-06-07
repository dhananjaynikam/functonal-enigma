package com.leetCode;

public class Sqrtx {
    public static void main(String args[]){
        System.out.print(mySqrt(8));
    }

    public static int mySqrt(int x){
        int l = 1;
        int r = x;
        long mid;

        while( l <= r){
            mid = ((long)l+(long)r)/2;

            if( mid * mid == x) return (int)mid;
            else if ( mid* mid > x)
                r = (int)mid-1;
            else
                l = (int)mid+1;
        }
        return r;
    }
}
