package com.leetCode;

public class LongestPrefix {
    public static void main(String args[]){
        String[] input = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(input));
    }

    public static String longestCommonPrefix(String[] strs){
        int min = strs[0].length();
        int index = 0;
        for(int i = 1; i < strs.length;i++){
            if(strs[i].length() < min){
                min = strs[i].length();
                index = i;
            }
        }
        String indexString = strs[index];
        int length = strs[index].length();
        for(int i = 0; i < strs.length;i++){
            if(i == index) continue;
            while(length > 0){
                if(strs[i].substring(0,length).equals(indexString.substring(0,length))){
                    break;
                }else{
                    length = length - 1;
                }
            }
            if(length == 0) return "";
        }

        return indexString.substring(0,length);
    }
}
