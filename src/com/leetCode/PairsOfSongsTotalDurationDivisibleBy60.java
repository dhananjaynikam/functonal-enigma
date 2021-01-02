package com.leetCode;

import java.util.HashMap;

public class PairsOfSongsTotalDurationDivisibleBy60 {
    public static void main(String args[]){
        System.out.println(numPairsDivisibleBy60Brute(new int[]{30,20,150,100,40}));
        System.out.println(numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
    }

    public static int numPairsDivisibleBy60Brute(int[] time){
        int total = 0;
        for(int i = 0; i < time.length;i++){
            for(int j = i+1;j<time.length;j++){
                if((time[i] + time[j]) % 60 == 0){
                    total ++;
                }
            }
        }
        return total;
    }

    public static int numPairsDivisibleBy60(int[] time){
        int total = 0;
        int key = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : time){
            key = 60 - (a%60);
            if(map.containsKey(key)){
                total += map.get(key);
            }
            if(a % 60 == 0){
                map.put(60, map.getOrDefault(60,0)+1);
            }else {
                map.put(a % 60, map.getOrDefault(a % 60, 0) + 1);
            }
        }
        return total;
    }
}
