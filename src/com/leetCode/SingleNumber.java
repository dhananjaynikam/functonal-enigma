package com.leetCode;

import java.util.HashSet;

public class SingleNumber {
    public static void main(String args[]){
        int[] nums = new int[]{2,2,1};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums){
        int numSum = 0;
        int duplicateSum = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length;i++){
            numSum = numSum + nums[i];
            if(!set.contains(nums[i])){
                duplicateSum = duplicateSum + nums[i];
                set.add(nums[i]);
            }
        }
        return 2*duplicateSum - numSum;
    }
}
