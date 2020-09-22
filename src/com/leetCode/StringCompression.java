package com.leetCode;

public class StringCompression {
    public static void main(String args[]){
        System.out.println(compressSlow(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(compress(new char[]{'a'}));
    }

    public static int compressSlow(char[] chars){
        if(chars.length == 1) return 1;
        StringBuilder answer = new StringBuilder();
        char item = chars[0];
        int count  = 1;
        for(int i = 1; i < chars.length; i++){
            if(item == chars[i]){
                count ++;
            }else{
                answer.append(item);
                answer.append(count);
                item = chars[i];
                count = 1;
            }
        }
        answer.append(item);
        answer.append(count);
        return answer.length();
    }

    public static int compress(char[] chars){
        int index = 0;
        int i = 0;
        while(i < chars.length){
            int j = i;
            while(j < chars.length && chars[j] == chars[i]){
                j++;
            }
            chars[index++] = chars[i];
            if(j - i > 1){
                String count = j-i + "";
                for(char c : count.toCharArray()){
                    chars[index++] = c;
                }
            }
            i = j;
        }
        return index;
    }
}
