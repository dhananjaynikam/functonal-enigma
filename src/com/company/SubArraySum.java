package com.company;

import java.util.Scanner;

public class SubArraySum implements Trial, Trial2{

    public static int getExceedsSum(int arr[], int target){
        int length = arr.length;
        for(int i = 0; i <= arr.length; i ++){
            int sum = arr[i];
            for(int k = i+1; k < arr.length; k++){
                if(sum >= target){
               //     k-i < length ? length = k :  ;
                    break;
                }

                sum = sum + arr[k];

            }
        }
        return 1;
    }
   /* public static void main (String[] args){
        Scanner in = new Scanner();
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i =0; i < n; i++){
            arr[i] = in.nextInt();
        }

        int target = in.nextInt();

        int result = getExceedsSum(arr, target);
    }*/
}
