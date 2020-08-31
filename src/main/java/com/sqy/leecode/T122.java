package com.sqy.leecode;

/**
 * @author: sunqingyuan
 * @date: 2020/8/31 17:00
 */

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 */
public class T122 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i = 1; i < prices.length ;i++){
            int target = 0;
            target = prices[i] - prices[i -1];
            if(target > 0){
                sum += target;
            }
        }

        return sum;
    }

}
