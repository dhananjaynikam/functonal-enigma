package com.leetCode;

public class ReverseInteger {
    public static void main(String args[]){
        System.out.print(reverse(-123));
        System.out.print(betterReverse(-123));
    }

    public static int reverse(int x){
        if(x == 0)
            return 0;
        StringBuilder ans = new StringBuilder();
        if(x < 0){
            ans.append("-");
            x = x * (-1);
        }

        while(x >0){
            ans.append(x % 10);
            x = x/10;
        }
        int answer = 0;
        try{
            answer = Integer.parseInt(ans.toString());
        }catch (NumberFormatException e){
            answer = 0;
        }
        return answer;
    }

    public static int betterReverse(int x){
        if(x == 0) return 0;

        long original = x;
        long answer = 0;
        while(original !=0){
            long temp = original%10;
            original = original/10;
            answer = answer*10 + temp;
        }
        if(answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) return 0;

        return (int)answer;
    }
}
