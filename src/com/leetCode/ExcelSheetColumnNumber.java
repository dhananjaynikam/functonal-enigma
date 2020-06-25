package com.leetCode;

public class ExcelSheetColumnNumber {
    public static void main(String args[]){
        System.out.println(titleToNumber("ABC"));
    }

    public static int titleToNumber(String s){
        int answer = 0;
        for(int i =0; i < s.length(); i++){
            answer = answer*26;
            answer = answer + (s.charAt(i) -'A'+1);
        }
        return answer;
    }
}
