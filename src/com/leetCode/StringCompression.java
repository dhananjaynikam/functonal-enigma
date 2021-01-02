package com.leetCode;

/*
Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

Follow up:
Could you solve it using only O(1) extra space?
 */

public class StringCompression {
    public static void main(String args[]){
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
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

    //make two pointers one to write and one to read. keep jumping to the read pointer once a different character is found
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
