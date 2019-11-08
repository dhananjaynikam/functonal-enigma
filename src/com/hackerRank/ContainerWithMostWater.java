package hackerRank;

public class ContainerWithMostWater {

    public static void main(String args[]){
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int max=Integer.MIN_VALUE;

        while(i <= j){
            int min = Math.min(height[i],height[j]);
            max = Math.max(max,min*(j-i));
            if(height[i] > height[j]){
                j--;
            }else
                i++;
        }
        return max;
    }
}
