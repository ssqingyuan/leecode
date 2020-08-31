package com.sqy.leecode;

/**
 * @author: sunqingyuan
 * @date: 2020/8/31 16:58
 */

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 */
public class T123maxProfit {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        if(prices.length < 1){
            return 0;
        }
        int[][][] dp = new int[prices.length][3][2];
        for(int i = 0;i<prices.length;i++){
            for(int j = 2;j>=1;j--){
                if (i - 1 == -1){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);

            }

        }
        return dp[prices.length-1][2][0];

    }

}
