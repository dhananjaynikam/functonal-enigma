package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String args[]){
        String s = "leetcode";
        String[] dict = new String[]{"leet","code"};
        List<String> wordDict = new ArrayList<>();
        wordDict.addAll(Arrays.asList(dict));
        //System.out.print(wordBreak(s,wordDict));
        //System.out.print(breakWord(s.toCharArray(),0,wordDict));
        System.out.print(breakWordDP(s,wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict){
        int anchor = 0;
        for(int i = 1; i<=s.length();i++){
            if(wordDict.contains(s.substring(anchor,i))){
                s = s.substring(i);
                i = 0;
            }
        }
        return s.length() == 0 ? true : false;
    }

    public static String breakWord(char[] str, int low, List<String> dictionary){
        StringBuffer buff = new StringBuffer();
        for(int i= low; i < str.length; i++){
            buff.append(str[i]);
            if(dictionary.contains(buff.toString())){
                String result = breakWord(str, i+1, dictionary);
                if(result != null){
                    return buff.toString() + " " + result;
                }
            }
        }
        if(dictionary.contains(buff.toString())){
            return buff.toString();
        }
        return null;
    }

    public static String breakWordDP(String word, List<String> dict){
        int T[][] = new int[word.length()][word.length()];

        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length ; j++){
                T[i][j] = -1; //-1 indicates string between i to j cannot be split
            }
        }

        //fill up the matrix in bottom up manner
        for(int l = 1; l <= word.length(); l++){
            for(int i=0; i < word.length() -l + 1 ; i++){
                int j = i + l-1;
                String str = word.substring(i,j+1);
                //if string between i to j is in dictionary T[i][j] is true
                if(dict.contains(str)){
                    T[i][j] = i;
                    continue;
                }
                //find a k between i+1 to j such that T[i][k-1] && T[k][j] are both true
                for(int k=i+1; k <= j; k++){
                    if(T[i][k-1] != -1 && T[k][j] != -1){
                        T[i][j] = k;
                        break;
                    }
                }
            }
        }
        if(T[0][word.length()-1] == -1){
            return null;
        }

        //create space separate word from string is possible
        StringBuffer buffer = new StringBuffer();
        int i = 0; int j = word.length() -1;
        while(i < j){
            int k = T[i][j];
            if(i == k){
                buffer.append(word.substring(i, j+1));
                break;
            }
            buffer.append(word.substring(i,k) + " ");
            i = k;
        }

        return buffer.toString();
    }
}
