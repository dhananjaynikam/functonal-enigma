package com.leetCode;

import java.util.HashSet;
import java.util.Set;

public class SentenceFormation {
    private static Set<String> dictionary = new HashSet<>();
    static {
        String temp_dictionary[] = {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};
        dictionary.add("mobile");
        dictionary.add("samsung");
        dictionary.add("sam");
        dictionary.add("sung");
        dictionary.add("man");
        dictionary.add("mango");
        dictionary.add("icecream");
        dictionary.add("and");
        dictionary.add("go");
        dictionary.add("i");
        dictionary.add("like");
        dictionary.add("ice");
        dictionary.add("cream");
    }

    private static boolean dict(String check){
        if(dictionary.contains(check)) return true;
        else return false;
    }


    public static void main(String args[]){
        String s = "ilikesamsung";
        System.out.println(findSentence(s));
    }

    public static String findSentence(String s){
        StringBuilder answer = new StringBuilder();
        int size = s.length();
        if(size == 0)
            return null;

        Boolean eachWord[] = new Boolean[size+1];
        for(int i = 0 ; i < eachWord.length;i++){
            eachWord[i] = false;
        }

        for(int i = 1 ; i<= size ; i++){
            if(eachWord[i] == false && dict(s.substring(0,i))) {
                eachWord[i] = true;
                answer.append(s, 0, i);
                answer.append(" ");
            }

            if(eachWord[i] == true){
                if(i == size) return answer.toString();

                for(int j = i+1 ; j <= size; j++){
                    if(eachWord[j] == false && dict(s.substring(i,j-i))) {
                        eachWord[j] = true;
                        answer.append(s, i, j-i);
                        answer.append(" ");
                    }

                    if(j == size && eachWord[j])
                        return answer.toString();
                }
            }
        }
        return answer.toString();
    }
}
