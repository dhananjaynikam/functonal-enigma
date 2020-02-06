package com.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Paranthesis {
    static HashMap<Character,Character> paraMap = new HashMap<Character,Character>(){{
        put('}','{');
        put(']','[');
        put(')','(');
    }};

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        //String input = "{[]}";
        System.out.print(isValid(input));
    }

    public static boolean isValid(String s) {
        Stack<Character> para = new Stack<>();
        char[] input = s.toCharArray();
        for(int i =0; i < input.length; i++){
            if(paraMap.containsValue(input[i])){
                para.push(input[i]);
            }else{
                if(para.empty() || para.pop() != paraMap.get(input[i])){
                    return false;
                }
            }
        }
        if(!para.empty()){
            return false;
        }
        return true;
    }
}
