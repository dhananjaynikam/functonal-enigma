package com.leetCode;

import java.util.ArrayList;

public class RemoveVowels {

    public static void main(String args[]){
        String s = "leetcodeisacommunityforcoders";
        System.out.print(removeVowels(s));
    }

    public static String removeVowels(String s){
        String vowels = "aeiou";
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char t = s.charAt(i);
            if(vowels.indexOf(t) == -1 ){
                ans.append(t);
            }
        }
        return ans.toString();
    }
}
