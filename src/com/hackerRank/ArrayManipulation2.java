package hackerRank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class ArrayManipulation2 {

    static long arrayManipulation(int n, int[][]queries){
        long[] arr = new long[n];
        long[] diff = new long[n+1];
        initializeDiffArray(arr, diff);

        for(int i = 0; i < queries.length; i++) {
            update(diff, queries[i][0] - 1, queries[i][1] - 1,queries[i][2]);
            finalChange(arr, diff);
        }

        Arrays.sort(arr);
        return arr[n-1];
    }

    static void initializeDiffArray(long arr[], long diff[])
    {

        int n = arr.length;

        diff[0] = arr[0];
        diff[n] = 0;
        for (int i = 1; i < n; i++)
            diff[i] = arr[i] - arr[i - 1];
    }

    static void update(long diff[], int l, int r, int x)
    {
        diff[l] += x;
        diff[r + 1] -= x;
    }

    static void finalChange(long arr[], long[] diff){
        for (int j = 0; j < arr.length; j++) {
            if (j == 0)
                arr[j] = diff[j];
            else
                arr[j] = diff[j] + arr[j - 1];

        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.print(result);
        scanner.close();
    }
}
