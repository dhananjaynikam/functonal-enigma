package com.leetCode;


public class SearchInsertPosition {
    public static void main(String args[]){
        int[] nums = new int[]{1};
        int target = 1;
        System.out.println(searchInsert(nums,target));
    }

    public static int searchInsert(int[] nums, int target) {
        int index = binarySearch(nums, target,0,nums.length-1);
        if(index == -1){
            index = insertAtLocation(nums, target);
        }
        return index;
    }
    public static int insertAtLocation(int[] nums, int target){
        int index= nums.length;
        if(nums[0] > target) return 0;
        for(int i =0; i < nums.length-1;i++){
            if(nums[i] < target && nums[i+1] > target) index= i+1;
        }
        return index;
    }
    public static int binarySearch(int[] nums, int target, int l, int r){
        if(r >= l){
            int mid = l + (r - l)/2;
            if(nums[mid] == target) return mid;

            if(nums[mid] > target){
                return binarySearch(nums,target,l,mid-1);
            }else {
                return binarySearch(nums, target,mid+1,r);
            }
        }
        return -1;
    }
}
