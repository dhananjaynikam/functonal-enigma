package com.leetCode;

public class TwoSum2 {
    public static void main(String args[]){
        int[] numbers = new int[]{2,7,11,15};
        System.out.print(twoSum(numbers,9));
    }

    public static int[] twoSum(int[] numbers, int target){
        int i = 0;
        int j = numbers.length-1;

        while (i < j){
            if(numbers[i] + numbers[j] < target){
                i++;
            }else if(numbers[i] + numbers[j] > target){
                j--;
            }else{
                return new int[]{i+1,j+1};
            }
        }
        return null;
    }
}
