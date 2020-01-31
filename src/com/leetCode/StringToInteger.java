package com.leetCode;

import java.util.Scanner;

public class StringToInteger {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        System.out.println(myAtoi(input));
    }
    public static int myAtoi(String str){
        if(str == null || str.length() == 0) return 0;

        //char[] ch = str.toCharArray();
        int minus = 0;
        int id = 0;
        str = str.trim();
        if(str.length()==0) return 0;

        int total = 0;
        for(int i = 0; i < str.length();i++){
            if(i == 0 && str.charAt(i) == '-') {
                minus = 1;
                continue;
            }
            if(i == 0 && str.charAt(i) == '+') continue;
            if(!Character.isDigit(str.charAt(i))) break;
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE%10 < str.charAt(i) - '0'){
                return minus != 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total*10+(str.charAt(i) - '0');
        }
        if(minus == 1) return -total;
        else return total;
    }
}
