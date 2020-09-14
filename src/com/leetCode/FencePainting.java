package com.leetCode;

public class FencePainting {
    public static void main(String args[]){
        System.out.print(fencePainting(5,3));
    }

    public static int fencePainting(int n, int k){
        int same = k;
        int diff = k*(k-1);
        int total = same + diff;

        for(int i = 3; i <= n ; i++){
            same = diff*1;
            diff = total*(k-1);
            total = same + diff;
        }
        return total;
    }
}
