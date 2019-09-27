package hackerRank;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int index[] = new int[2];
        for(int i =0; i < nums.length-1 ; i++){
            for(int j=i+1; j < nums.length ; j++){
                int sum = nums[i] + nums[j];
                if(sum == target){
                    index[0] = i;
                    index[1] = j;
                    break;
                }
            }
        }
        return index;
    }

    public static void main (String args[]){
        int num[] = new int[]{-1,-2,-3,-4,-5};
        int sum = -8;
        int[] index = twoSum(num, sum);
        for (int i: index) {
            System.out.println(i);
        }

    }
}
