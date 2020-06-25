package com.leetCode;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
    public static void main(String args[]){
        //int[] nums = new int[]{2,2,1,1,1,2,2};
        int[] nums1 = new int[]{6,5,5};
        //System.out.print(majorityElement(nums));
        System.out.print(majorityElement(nums1));
        System.out.print(majorityElement1(nums1));
    }

    public static int majorityElement(int[] nums){
        HashMap<Integer, Integer> results = new HashMap<>();
        int max = nums[0];
        results.put(max,1);
        for(int i = 1; i < nums.length;i++){
            if(results.containsKey(nums[i])){
                int temp = results.get(nums[i]);
                results.replace(nums[i],temp+1);
                if(temp+1 > results.get(max)){
                    max = nums[i];
                }
            }else{
                results.put(nums[i],1);
            }
        }
        return max;
    }

    public static int majorityElement1(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
