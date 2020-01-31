package com.leetCode;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinMaxSum {
    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long min = 0;
        long max = 0;
        Arrays.sort(arr);
        for(int a = 1; a < arr.length; a++){
            max = max + arr[a];
        }
        for(int a = 0; a < arr.length-1; a++)
            min = min + arr[a];

        System.out.print(min + " " + max);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = {"1","2","3","4","5"};
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

       // scanner.close();
    }
}
