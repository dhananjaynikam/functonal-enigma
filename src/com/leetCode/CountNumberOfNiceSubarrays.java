package com.leetCode;

/*
Given an array of integers nums and an integer k. A subarray is called nice if there are k odd numbers on it.
Return the number of nice sub-arrays.
 */

public class CountNumberOfNiceSubarrays {
    public static void main(String args[]){
        System.out.println(numberOfSubarrays(new int[]{1,1,2,1,1}, 3));
    }

    //find the sub array which has the K number of odds.
    //check the number of even numbers on the left and the right of that sub array
    //multiplication of the number of evens on the left and right will give the count with the current subarray
    //so add it with the previous count
    public static int numberOfSubarrays(int[] nums, int k){
        int l = 0;
        int r = -1;
        int count = 0;
        int odd = 0;
        while(r < nums.length - 1){
            r++;
            if(nums[r] % 2 == 1){
                odd++;
            }
            if(odd == k){
                int left = 1;
                int right = 1;
                while(r < nums.length - 1 && nums[r+1] % 2 ==0){
                    right ++;
                    r++;
                }
                while(l <= r && nums[l] % 2 == 0){
                    left ++;
                    l++;
                }
                count += left*right;
                l++;
                odd--;
            }
        }
        return count;
    }
}
