package com.leetCode;
/*
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

public class ClimbingStairs {
    public static void main(String args[]){
        System.out.println(climbStairsRecursive(8));
        System.out.println(climbStairsMemoization(8));
        System.out.println(climbStairsDP(8));
    }

    public static int climbStairsRecursive(int n) {
        return climb_Stairs_Recursive(0, n);
    }
    public static int climb_Stairs_Recursive(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs_Recursive(i + 1, n) + climb_Stairs_Recursive(i + 2, n);
    }

    public static int climbStairsMemoization(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs_Memoization(0, n, memo);
    }

    public static int climb_Stairs_Memoization(int i, int n, int memo[]) {
            if (i > n) {
                return 0;
            }
            if (i == n) {
                return 1;
            }
            if (memo[i] > 0) {
                return memo[i];
            }
            memo[i] = climb_Stairs_Memoization(i + 1, n, memo) + climb_Stairs_Memoization(i + 2, n, memo);
            return memo[i];
        }

    public static int climbStairsDP(int n){
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
