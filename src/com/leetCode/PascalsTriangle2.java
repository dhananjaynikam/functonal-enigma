package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle2 {
    public static void main(String args[]){
        List<Integer> answer = getRow(5);
        List<Integer> answer1 = getRowBinomial(5);
        for(int a : answer){
            System.out.println(a);
        }
    }

    public static List<Integer> getRow(int i){
        if(i < 0){
            return new ArrayList<Integer>();
        }
        if(i == 0){
            return Arrays.asList(1);
        }
        if(i == 1){
            return Arrays.asList(1,1);
        }
        List<Integer> prevRow = getRow(i-1);
        List<Integer> last = new ArrayList<>(Arrays.asList(1));
        for(int j = 1; j < prevRow.size();j++){
            last.add(prevRow.get(j-1) + prevRow.get(j));
        }
        last.add(1);
        return last;
    }

    public static List<Integer> getRowBinomial(int rowIndex){
        List<Integer> ans = new LinkedList<>();
        long num = 1;
        for (int i = 0; i <= rowIndex; i++) {
            ans.add(Math.toIntExact(num));
            num = num * (rowIndex-i) / (i+1);
        }
        return ans;
    }
}
