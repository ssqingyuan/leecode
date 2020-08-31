package com.sqy.leecode;

/**
 * @author: sunqingyuan
 * @date: 2020/8/31 16:55
 */

/**
 *给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class T5longestPalindrome {
    public static void main(String[] args) {

    }
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0 ;i < n ;i ++){
            dp[i][i] = true;
        }
        int begin = 0;
        int maxLen = 1;
        for(int j = 1;j < n ;j++){
            for(int i = 0; j > i ; i++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else {
                    dp[i][j] = false;
                }

                if(dp[i][j] && j - i +1 > maxLen){
                    maxLen = j - i +1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin + maxLen);
    }
}
