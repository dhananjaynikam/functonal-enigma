package com.leetCode;

public class DivideTwoIntegers {
    public static void main(String args[]){
        int dividend = -2147483648;
        int divisor = 2;
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.print(divide(dividend,divisor));
    }
    static int divide(int dividend, int divisor){
        boolean positive = dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0;
        if ((dividend == Integer.MAX_VALUE || dividend == Integer.MIN_VALUE) && Math.abs((long) divisor) <= 1) {
            return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        long end = Math.abs((long) dividend);
        long sor = Math.abs((long) divisor);

        if (sor > end) return 0;
        else if (sor == end) return positive ? 1 : -1;

        long lo = 0, hi = end;
        while (lo <= hi) {
            long mid = ((hi - lo) >> 1) + lo;
            long y = sor * mid;
            if (y > end)
                hi = mid - 1;
            else if (y < end)
                lo = mid + 1;
            else
                return positive ? (int) mid : (int) -mid;
        }
        return positive ? (int) hi : (int) -hi;
    }
}
