package com.leetCode;

import java.util.HashMap;

/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
If the fractional part is repeating, enclose the repeating part in parentheses.
If multiple answers are possible, return any of them.
 */

public class FractionOfRecurrinDecimal {
    public static void main(String args[]){
        System.out.print(fractionToDecimal(4,9));
    }

    public static String fractionToDecimal(int numerator, int denominator){
        //obviously
        if(numerator == 0) return "0";

        StringBuilder answer = new StringBuilder();
        //obviously
        if(numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0){
            answer.append("-");
        }
        //control the overflow
        long divisor = Math.abs((long)numerator);
        long dividend = Math.abs((long)denominator);
        long remainder = divisor % dividend;
        answer.append(divisor/dividend);
        //if the number is completely divisible
        if(remainder == 0){
            return answer.toString();
        }
        answer.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        while(remainder != 0){
            //if the remainder has been previously encountered it is going to repeat from the index it was encountered at
            if(map.containsKey(remainder)){
                //if the remainder was encountered we have stored the location and will add the '(' there and the ')' at the end
                answer.insert(map.get(remainder), "(");
                answer.append(")");
                break;
            }
            //regular long division
            //savingeach remainder and location
            map.put(remainder, answer.length());
            remainder *= 10;
            answer.append(remainder/dividend);
            remainder = remainder %dividend;
        }
        return answer.toString();
    }
}