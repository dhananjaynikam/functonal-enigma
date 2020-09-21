package com.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MaximumNumberOfOccurrencesSubstring {
    public static void main(String args[]){
        String s = "aababcaab";
        System.out.print(maxFreq(s,2,3,4));
    }

    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize){
        int N = s.length();
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N-minSize+1;i++){
            HashSet<String> set = new HashSet<>();
            for(int k = 1; k < minSize+1;k++){
                set.add((s.substring(i+k-1)));
                if(set.size() > maxLetters){
                    break;
                }
            if(set.size() <= maxLetters){
                String s1 = s.substring(i, i + k);
                if(map.get(s1) == null){
                    map.put(s1,1);
                }else{
                    map.put(s1,map.get(s1)+1);
                }
            }
            }
        }
        int best = 0;
        for(Map.Entry<String,Integer> a : map.entrySet()){
            best = Math.max(a.getValue(),best);
        }
        return best;
    }

}
