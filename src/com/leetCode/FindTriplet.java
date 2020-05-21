package com.leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FindTriplet {
    public static void main(String args[]){
        int a1[] = {1, 2, 3, 4, 5};
        int a2[] = {2, 3, 6, 1, 2};
        int a3[] = {-3, -2, -4, -5, -6};
        System.out.println(findTriplet(a1,a2,a3));
    }

    public static boolean findTriplet(int[] a1, int[] a2, int[] a3){
        int length_a1 = a1.length;
        int length_a2 = a2.length;
        int length_a3 = a3.length;

        Set<Integer> seta3 = new HashSet<Integer>();
        for(int i = 0; i<length_a3;i++){
            seta3.add(a3[i]);
        }

        ArrayList<Integer> sum = new ArrayList<>();
        for(int i = 0; i<length_a1;i++){
            for(int j = 0; j <length_a2;j++){
                sum.add(a1[i] + a2[j]);
            }
        }

        for(int i = 0; i<sum.size();i++){
            if(seta3.contains(sum.get(i)))
                return true;
        }
        return false;
    }
}
