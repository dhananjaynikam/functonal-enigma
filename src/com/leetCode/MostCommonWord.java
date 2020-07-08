package com.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MostCommonWord {
    public static void main(String args[]){
       String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
       String[] banned = new String[]{"hit"};
       System.out.print(mostCommonWord(paragraph,banned));
        System.out.print(mostCommonWordCharWise(paragraph,banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned){
        String[] para = paragraph.split(" ");
        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word.toLowerCase());

        HashMap<String, Integer> count = new HashMap<>();

        String ans = "";
        int max = 0;
        for(String s: para){
            s = s.replaceAll("[^A-Za-z]+","").toLowerCase();
            if(!banset.contains(s)){
                count.put(s,count.getOrDefault(s,0)+1);
                if(count.get(s) > max){
                    ans = s;
                    max = count.get(s);
                }
            }

        }
        return ans;
    }

    public static String mostCommonWordCharWise(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        HashMap<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }
}
