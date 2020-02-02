package com.leetCode;

import java.util.HashMap;

public class RomanToInteger {
    static HashMap<String, Integer> conversionMap = new HashMap<String, Integer>(){{
        put("I", 1);
        put("IV", 4);
        put("V", 5);
        put("IX", 9);
        put("X", 10);
        put("XL", 40);
        put("L", 50);
        put("XC", 90);
        put("C", 100);
        put("CD", 400);
        put("D", 500);
        put("CM", 900);
        put("M", 1000);
    }};

    public static void main(String args[]){
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("DCXXI"));
    }

    public static int romanToInt(String s){
        int answer = 0;

        for(int i =0; i< s.length();i++){
            switch (s.charAt(i)){
                case 'I': {
                    if((i + 1 < s.length()) && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')){
                        answer = answer + conversionMap.get(new String (new char[]{s.charAt(i),s.charAt(i+1)}));
                        i++;
                    }else {
                        answer = answer + conversionMap.get(new String (new char[]{s.charAt(i)}));
                    }
                    break;
                }
                case 'X': {
                    if((i + 1 < s.length()) && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')){
                        answer = answer + conversionMap.get(new String (new char[]{s.charAt(i),s.charAt(i+1)}));
                        i++;
                    }else {
                        answer = answer + conversionMap.get(new String (new char[]{s.charAt(i)}));
                    }
                    break;
                }
                case 'C': {
                    if((i + 1 < s.length()) && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
                        answer = answer + conversionMap.get(new String (new char[]{s.charAt(i),s.charAt(i+1)}));
                        i++;
                    }else {
                        answer = answer + conversionMap.get(new String (new char[]{s.charAt(i)}));
                    }
                    break;
                }
                default : {
                    answer = answer + conversionMap.get(new String (new char[]{s.charAt(i)}));
                    break;
                }
            }

        }
        return answer;
    }
}
