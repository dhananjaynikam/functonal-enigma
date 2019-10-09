package hackerRank;

import java.util.HashMap;

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

    public static int[] twoSumMap(int[] nums, int target){
        HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
        data.put(nums[0],0);
        for(int i = 1 ; i < nums.length; i++){
            int check = target - nums[i];
            if(data.get(check) != null){
                return new int[]{data.get(check), i};
            }else{
                data.put(nums[i], i);
            }
        }
        return new int[2];
    }

    public static void main (String args[]){
        int num[] = new int[]{3,3};
        int sum = 6;
        int[] index = twoSum(num, sum);
        int [] ans = twoSumMap(num, sum);
        for(int i: ans ){
            System.out.println(i);
        }
        for (int i: index) {
            System.out.println(i);
        }

    }
}
