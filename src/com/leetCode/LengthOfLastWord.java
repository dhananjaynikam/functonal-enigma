package com.leetCode;

public class LengthOfLastWord {
    public static void main(String args[]){
        String input = " ";
        System.out.println(lengthOfLastWord(input));
        System.out.println(lengthOfLastWordBest(input));
    }

    public static int lengthOfLastWord(String s) {
        if(s.length() == 0)
            return 0;

        String[] input_arr = s.split(" ");
        String last_word = input_arr.length == 0 ? null : input_arr[input_arr.length-1];

        if(last_word == null)return 0;
        else return last_word.length();
    }

    public static int lengthOfLastWordBest(String s){
        int count =0;
        for(int i = s.length()-1; i >=0; i--){
            if(s.charAt(i) == ' ') {
                if (count != 0)
                    return count;
            }
            else{
                count ++;
            }
        }
        return count;
    }
}
