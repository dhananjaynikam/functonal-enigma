package com.leetCode;

public class PalindromeNumber {
    public static void main(String args[]){
        System.out.print(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x){
        if(x < 0) return false;
        int number = x;
        int answer = 0;
        while(number != 0){
            int temp = number % 10;
            answer = answer*10 + temp;
            number = number/10;
        }
        if(answer == x) return true;

        return false;
    }
}
