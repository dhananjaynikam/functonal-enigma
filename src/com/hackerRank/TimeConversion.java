package hackerRank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversion {
    static void timeConversion(String s) {
        StringBuilder result = new StringBuilder();
        String[] split = s.split(":");
        String hr = split[0];
        String min = split[1];
        String sec = split[2];


        if(s.contains("PM")){
            int h = Integer.parseInt(hr);
            if(h != 12) {
                h = h + 12;
            }else h = 12;

            result.append(h + ":");
        } else {
            if(hr.equals("12"))
                result.append("00:");
            else result.append(hr + ":");
        }

        result.append(min + ":");

        for(int i = 0; i  <sec.length(); i++){
            if(Character.isDigit(sec.charAt(i))) result.append(sec.charAt(i));
        }

        System.out.println(result);

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = "12:00:00PM";
        String a = "12:00:00AM";
        String b = "07:12:00AM";
        String c = "07:12:00PM";

        timeConversion(s);
        timeConversion(a);
        timeConversion(b);
        timeConversion(c);


    }
}
