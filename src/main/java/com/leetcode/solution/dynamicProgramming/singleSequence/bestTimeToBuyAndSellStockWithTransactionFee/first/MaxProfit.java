package com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockWithTransactionFee.first;

import com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockWithTransactionFee.MaxProfitTemplate;

public class MaxProfit extends MaxProfitTemplate {
    @Override
    public int maxProfit(int[] prices, int fee) {
        // state => dp[i][j] 表示第i天持股状态j下的最大收益 => j = 0 | 1
        // status function =>
        //                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee)
        //                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i])
        // condition => dp[0][0] = 0 & dp[0][1] = -prices[0]
        // solution => get dp[prices.length - 1][0]
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        // int[][] dp = new int[len][2];
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1] + prices[i] - fee);
            dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], dp[(i - 1) % 2][0] - prices[i]);
        }

        return dp[(len - 1) % 2][0];
    }
}
