package com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeAndSellStockWithCooldown.first;

import com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeAndSellStockWithCooldown.MaxProfitTemplate;

public class MaxProfit extends MaxProfitTemplate {
    @Override
    public int maxProfit(int[] prices) {
        // state => dp[i][j] 表示第i天持股状态为j的最大收益 => j = 0 | 1
        // status function =>
        //                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
        //                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i])
        // condition => dp[0][0] = 0 & dp[0][1] = -prices[0]
        // solution => get dp[prices.length - 1][0]
        if (prices == null || prices.length < 2) {
            // corn case => length == 1
            return 0;
        }

        int len = prices.length;
        // int[][] dp = new int[len][2];
        int[][] dp = new int[3][2];
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);

        for (int i = 2; i < len; i++) {
            dp[i % 3][0] = Math.max(dp[(i - 1) % 3][0], dp[(i - 1) % 3][1] + prices[i]);
            dp[i % 3][1] = Math.max(dp[(i - 1) % 3][1], dp[(i - 2) % 3][0] - prices[i]);
        }

        return dp[(len - 1) % 3][0];
    }
}
