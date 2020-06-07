package com.leetCode;

public class MergeSortedArrays {
    public static void main(String args[]){
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int[] answer = merge(nums1, 3,nums2, nums2.length);
        for (int a: answer
             ) {
            System.out.println(a);
        }

    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n){
        int index1 = m-1;   //point to last num in nums1 array
        int index2 = n-1;     //point to last num in nums2 array

        for(int i = (m+n-1) ; i >= 0 ; i--){
            if(index1 < 0){
                //if index1 is less than 0,
                // means nums1 has no more items left to compare, insert nums2's left over
                nums1[i] = nums2[i];
            } else if(index2 >= 0){
                nums1[i] =  (nums1[index1] > nums2[index2]) ? nums1[index1--] : nums2[index2--];
            }
            // else
            //no more items in nums2 to compare, leave nums1 as it is.
        }
        return nums1;
    }
}