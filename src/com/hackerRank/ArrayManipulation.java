package hackerRank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

    public class ArrayManipulation {

        // Complete the arrayManipulation function below.
        static long arrayManipulation(int n, int[][] queries) {

            long[] arr = new long[n];
            for(int i = 0; i < queries.length; i++) {
                int start = queries[i][0] - 1;
                int end = queries[i][1] - 1;
                int add = queries[i][2];
                for(int j = start; j <= end; j++) {
                    arr[j] = arr[j] + add;
                }
            }

           Arrays.sort(arr);
           long sum = arr[n-1];
           return sum;
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
