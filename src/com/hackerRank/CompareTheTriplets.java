package hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CompareTheTriplets {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        List<Integer> result = new ArrayList<Integer>();
        HashMap<String, Integer> temp = new HashMap<String, Integer>();
        temp.put("a", 0);
        temp.put("b", 0);

        for(int i = 0; i < a.size(); i++){
            if(a.get(i) < b.get(i)){
                temp.put("b", temp.get("b") + 1);
            }else if(a.get(i) == b.get(i)){
                continue;
            }else temp.put("a", temp.get("a") + 1);
        }

        result.add(temp.get("a"));
        result.add(temp.get("b"));
        return result;
    }

    public static void main(String[] args) throws IOException {
       // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] aItems = {"17", "18", "30"};

        List<Integer> a = new ArrayList<Integer>();

        for (int i = 0; i < 3; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a.add(aItem);
        }

        String[] bItems = {"99", "16", "8"} ;

        List<Integer> b = new ArrayList<Integer>();

        for (int i = 0; i < 3; i++) {
            int bItem = Integer.parseInt(bItems[i]);
            b.add(bItem);
        }

        List<Integer> result = compareTriplets(a, b);

        for (int i : result) {
            System.out.print(i);
        }
    }
}
