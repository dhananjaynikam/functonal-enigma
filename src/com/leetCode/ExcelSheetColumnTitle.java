package com.leetCode;

public class ExcelSheetColumnTitle {
    public static void main(String args[]){
        convertToTitle(1);
        convertToTitle(28);
        convertToTitle(701);
        convertToTitle(52);
    }

    public static String convertToTitle(int n) {
        StringBuilder answer = new StringBuilder();
        while(n > 0){
            int rem = n % 26;
            if(rem == 0 ){
                answer.append("Z");
                n = (n/26) - 1;
            }else{
                answer.append((char)((rem - 1) + 'A'));
                n = n / 26;
            }
        }
        System.out.println(answer.reverse().toString());
        return null;
    }
}
