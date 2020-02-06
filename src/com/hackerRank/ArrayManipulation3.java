package hackerRank;

import java.io.IOException;
import java.util.Scanner;


public class ArrayManipulation3 {

    static long arrayManipulation(int n, int[][]queries) {
       long max = 0;
       long sum = 0;
       long arr[] = new long[n+2];
        for(int i = 0; i < queries.length; i++ ) {
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];
            arr[a] = arr[a] + k;
            arr[b + 1] = arr[b + 1] - k;
        }
       for(int i = 1; i < arr.length; i++ ){
           sum = arr[i] + sum;
           max = Math.max(max, sum);
       }
        return max;
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
