package com.leetCode;

public class AddBinary {
    public static void main(String args[]){
        System.out.println(addBinary("1010","1011"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder answer = new StringBuilder();

        int a_length = a.length() - 1;
        int b_length = b.length() - 1;

        int carry = 0;
        while (a_length >= 0 || b_length >= 0) {
            int sum = carry;
            if (a_length >= 0)
                sum = sum + a.charAt(a_length) - '0';
            if (b_length >= 0)
                sum = sum + b.charAt(b_length) - '0';
            answer.append(sum % 2);
            carry = sum / 2;
            a_length--;
            b_length--;
        }
        if (carry != 0) answer.append(carry);
        return answer.reverse().toString();
    }
}
