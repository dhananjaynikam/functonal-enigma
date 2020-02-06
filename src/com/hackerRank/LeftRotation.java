package hackerRank;

import java.util.*;


public class LeftRotation {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        //int[] temp = new int[d];

        for(int i = 1; i <= d; i++) {
            int temp =  a[0];
            for(int j = 0; j < n-1; j++){
                a[j] = a[j+1];
            } a[n-1] = temp;
        }
        for (int i = 0; i < n; i++)
            System.out.print(a[i]+" ");

        scanner.close();
    }
}

