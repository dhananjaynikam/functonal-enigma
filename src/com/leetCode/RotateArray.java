package com.leetCode;

public class RotateArray {
    public static void main(String args[]){
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        rotate(nums, 3);
        for (int a: nums
             ) {
            System.out.print(a+",");
        }
    }

    public static void rotate(int[] nums, int k){
        int[] temp = nums.clone();

        for(int i = 0; i < temp.length; i ++){
            int new_pos = (i+k)%nums.length;
            nums[new_pos] = temp[i];
        }

    }

    public static void rotateWithoutSpace(int[] nums, int k){
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
