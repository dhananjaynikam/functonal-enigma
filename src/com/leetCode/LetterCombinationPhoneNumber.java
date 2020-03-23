package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationPhoneNumber {
    public static HashMap<String, String>phone = new HashMap<String, String>(){{
        put("2","abc");
        put("3","def");
        put("4","ghi");
        put("5","jkl");
        put("6","mno");
        put("7","pqrs");
        put("8","tuv");
        put("9","wxyz");
    }};

    public static List<String> output = new ArrayList<>();

    public static void main(String args[]){
        System.out.println(letterCombinations(""));
    }

    public static void backtrack(String combination, String nextDigits){
        if(nextDigits.length() == 0){
            output.add(combination);
        }
        else{
            String digit = nextDigits.substring(0,1);
            String letters = phone.get(digit);
            for(int i = 0; i < letters.length();i++){
                String letter = letters.substring(i,i+1);
                backtrack(combination+letter,nextDigits.substring(1));
            }
        }
    }
    public static List<String> letterCombinations(String digits){
        if(digits.length() != 0)
            backtrack("",digits);
        return output;
    }
}
