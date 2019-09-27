package hackerRank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class ArraySum {

    /*
     * Complete the simpleArraySum function below.
     */
    static int simpleArraySum(int[] ar) {
        /*
         * Write your code here.
         */
        int sum = 0;

        for (int a : ar) {
            sum = sum + a;
        }

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = 6;

        int[] ar = new int[arCount];

        int[] arItems = {1,2,3,4,5,6};

        for (int arItr = 0; arItr < arCount; arItr++) {
            int arItem = arItems[arItr];
            ar[arItr] = arItem;
        }

        int result = simpleArraySum(ar);

        System.out.print(result);
    }
}
