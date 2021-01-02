package com.leetCode;

public class RunningSumOf1DArray {
    public static void main(String args[]){
        int[] nums = new int[]{1,2,3,4};
        int[] ans = runningSum(nums);
        for (int a:ans) {
            System.out.print(a);
        }
    }

    public static int[] runningSum(int[] nums){
        for(int i =1; i < nums.length; i++){
            nums[i] = nums[i] + nums[i-1];
        }
        return nums;
    }
}
