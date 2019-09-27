package hackerRank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BirthdayCakeCandles {

    static int birthdayCakeCandles(int[] ar) {
        int result = 0;

        Arrays.sort(ar);
        int max = ar[ar.length-1];

        for(int a : ar){
            if(a == max){
                result++;
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = 4;
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = {3,2,1,3};

        int result = birthdayCakeCandles(ar);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
            System.out.print(result);
    }
}
