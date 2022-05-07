package com.gatsby;

/**
 * @ClassName: _121BestTimeToBuyAndSellStock
 * @Description: leetcode 121 买卖股票的最好时机
 * @author: Gatsby
 * @date: 2022/5/7 17:04
 */

public class _121BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int price = prices[0];
        int profit = 0;
        for (int p : prices) {
            if (p < price) {
                price = p;
            }
            profit = Math.max(p - price, profit);
        }
        return profit;
    }
}


