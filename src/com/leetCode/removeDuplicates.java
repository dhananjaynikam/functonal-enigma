package com.leetCode;

import java.util.ArrayList;

public class removeDuplicates {
    public static void main(String args[]){
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums){
        if(nums.length == 0) return 0;

        int unique = 0;
        ArrayList<Integer> visited = new ArrayList<>();

        for(int i =0; i < nums.length; i++){
            if(visited.contains(nums[i])) continue;
            else{
                unique++;
                visited.add(nums[i]);
            }
        }

        for(int i = 0; i < visited.size(); i++){
            nums[i] = visited.get(i);
        }

        return unique;
    }

    public static int removeDuplicateFaster(int[] nums){
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
