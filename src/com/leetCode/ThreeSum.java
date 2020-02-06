package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String args[]){
        int[] nums = new int[] {-2,0,1,1,2};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> answer = new ArrayList<>();
        if(nums.length < 3) return answer;

        Arrays.sort(nums);

        int start, last,sum;
        for(int i =0; i < nums.length;i++){
            start = i+1;
            last = nums.length-1;

            while(start < last){
                sum = nums[i]+nums[last]+nums[start];
                if(sum == 0){
                    answer.add(Arrays.asList(nums[i],nums[start],nums[last]));
                    start++;
                    last--;
                    while(start < last && nums[start] == nums[start -1]) start++;
                    while(start < last && nums[last] == nums[last +1]) last --;
                }else if(sum < 0){
                    start ++;
                }else {
                    last--;
                }
            }
            while(i < nums.length-1 && nums[i] == nums[i+1]) i++;
        }
        return answer;
    }
}
