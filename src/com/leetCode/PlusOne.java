package com.leetCode;

public class PlusOne {
    public static void main(String args[]){
        int[] digits = new int[]{9,9,9};
        System.out.println(plusOne(digits));
    }

    public static int[] plusOne(int[] digits){
        int[] answer = new int[digits.length+1];
        boolean carry = true;

        for(int i = digits.length-1;i>=0;i--){
            if(carry){
                int temp = digits[i] + 1;
                if(temp == 10){
                    answer[i+1] = 0;
                    carry = true;
                }else{
                    answer[i+1] = temp;
                    carry = false;
                }
            }else{
                answer[i+1] = digits[i];
            }
        }
        if(carry){
            answer[0] = 1;
            return answer;
        }else{
            int[] answer1 = new int[digits.length];
            for(int i = 1; i < answer.length;i++){
                answer1[i-1] = answer[i];
            }
            return answer1;
        }
    }
}
