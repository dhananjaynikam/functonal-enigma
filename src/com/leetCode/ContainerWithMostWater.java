package com.leetCode;

public class ContainerWithMostWater {
    public static void main(String args[]){
        System.out.println(maxArea(new int[] {1,2,3,4,5,6,7}));
    }

    public static int maxArea(int[] height) {
        int area = 0;
        int l = 0;
        int r = height.length-1;
        while(l < r){
            area = Math.max(area, Math.min(height[l],height[r])*(r-l));
            if(height[l] < height[r])
                l++;
            else r--;
        }
        return area;
    }
}
