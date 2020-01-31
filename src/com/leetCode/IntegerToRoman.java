package com.leetCode;

public class IntegerToRoman {
    public static void main(String args[]){
        int input = 1994;
        System.out.println(intToRoman(input));
    }

    public static String intToRoman(int num){
        StringBuilder stringBuilder = new StringBuilder();
        int[] nums = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] ss = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        for (int i=nums.length-1; i>=0; i--){
            if (num == 0){
                break;
            }
            while (num>=nums[i]){
                stringBuilder.append(ss[i]);
                num -= nums[i];
            }
        }
        return new String(stringBuilder);
    }
}
