package com.leetCode;

public class ValidPalindrome {
    public static void main(String args[]){
        String s = "A man, a plan, a canal: Panama";
        String a = "0P";
        System.out.println(checkPalindrome(s));
        System.out.println(checkPalindrome(a));
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome(a));
    }

    public static boolean checkIfPalindrome(int start, int end, String s){
        if(start < end){
            if(s.charAt(start) == s.charAt(end)){
                return checkIfPalindrome(++start, --end,s);
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static boolean checkPalindrome(String s){
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int n = s.length()-1;
        int i = 0;
        while(i < n){
            if(s.charAt(i) != s.charAt(n)){
                return false;
            }
            i++;
            n--;
        }
        return true;
    }

    public static boolean isPalindrome(String s){
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        return checkIfPalindrome(0,s.length()-1,s);
    }
}
