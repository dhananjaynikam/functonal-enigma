package com.leetCode;

import java.util.Arrays;

public class KclosestPointsToOrigin {
    public static void main(String args[]){
        int[][] points = new int[][]{{1,3},{-2,2}};
        int[][] answer = kClosest(points,1);
        for(int[] a : answer){
            for(int j : a){
                System.out.print(j+",");
            }
        }
    }

    public static int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; ++i)
            dists[i] = dist(points[i]);

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; ++i)
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];
        return ans;
    }

    public static int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
