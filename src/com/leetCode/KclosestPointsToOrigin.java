package com.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 */
public class KclosestPointsToOrigin {
    public static void main(String args[]){
        int[][] points = new int[][]{{1,3},{-2,2}};
        int[][] answer = kClosest(points,1);
        int[][] answer2 = kClosestPoints(points,1);
        for(int[] a : answer2){
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
        //find distances of all the points
        //sort all the points according to the distances
        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        //map the points to their distances and add to the ans array
        for (int i = 0; i < N; ++i)
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];
        return ans;
    }

    public static int[][] kClosestPoints(int[][] points, int K){
        //correct and probably faster than most but needs to maintain the order. Good display of DS
        int N = points.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        HashMap<Integer,int[]> map = new HashMap<>();

        for(int i = 0; i< N;i++){
            int distance = dist(points[i]);
            queue.add(distance);
            map.put(distance,points[i]);
        }

        int[][] ans = new int[K][2];
        for(int i = 0; i < K; i++){
            int top = queue.remove();
            ans[i] = map.get(top);
        }
        return ans;
    }

    public static int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
