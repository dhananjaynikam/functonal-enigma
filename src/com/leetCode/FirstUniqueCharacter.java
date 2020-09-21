package com.leetCode;

public class FirstUniqueCharacter {
    public static void main(String args[]){
        String s = "leetcode";
        System.out.println(firstUniqueChar(s));
    }

    public static int firstUniqueChar(String s){
        int[] alphabets = new int[27];
        for(int i = 0; i < s.length(); i++){
            int temp = s.charAt(i) - 'a'+1;
            alphabets[temp] += 1;
        }
        for(int i = 0; i < s.length();i++){
            int temp = s.charAt(i) - 'a'+1;
            if(alphabets[temp] == 1)
                return i;
        }
        return -1;
    }
}
