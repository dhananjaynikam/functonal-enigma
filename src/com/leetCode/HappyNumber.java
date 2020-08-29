package com.leetCode;

import java.util.HashSet;

public class HappyNumber {
    public static void main(String args[]){
        int number = 19;
        System.out.println(isHappy(number));
    }

    public static boolean isHappy(int n){
        HashSet<Integer> values = new HashSet<>();

        while(!values.contains(n)){
            values.add(n);
            n = findSquareSum(n);
            if(n == 1){
                return true;
            }
        }
        return false;
    }

    public static int findSquareSum(int n){
        int sum = 0;
        while(n > 0){
            sum = sum + (n%10)*(n%10);
            n = n/10;
        }
        return sum;
    }
}
