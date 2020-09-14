package com.leetCode;

public class DecodeWays {
    public static void main(String args[]){
        System.out.println(numDecodings("226"));
        System.out.print(numDecode("226"));
    }

    public static int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        // initialize
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        // induction rules
        for(int i = 2; i < dp.length; i++){
            dp[i] = (s.charAt(i-1) == '0') ? 0 : dp[i-1];
            if(s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6')) {
                dp[i] += dp[i-2];
            }
        }
        return dp[dp.length - 1];
    }

    public static int numDecode(String s){
        if(s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0 : 1;

        for(int i = 2; i <= s.length();i++){
            int single = s.charAt(i-1) - '0';
            int dou = (s.charAt(i-2)-'0')*10 + single;
            if(single >= 1 && single <= 9){
                dp[i] = dp[i]+dp[i-1];
            }
            if(dou >=10 && dou <=26){
                dp[i] = dp[i] + dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
