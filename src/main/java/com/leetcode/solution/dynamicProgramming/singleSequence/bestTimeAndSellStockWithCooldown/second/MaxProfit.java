package com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeAndSellStockWithCooldown.second;

import com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeAndSellStockWithCooldown.MaxProfitTemplate;

public class MaxProfit extends MaxProfitTemplate {
    @Override
    public int maxProfit(int[] prices) {
        // 🥶冷冻期 => dp[i - 2][0] - prices[i] => dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        // state => dp[i][j] 表示第i天持股状态为j的情况下的余额
        // status function =>
        //                  dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
        //                  dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        // condition => dp[0][0] = 0  dp[0][1] = -prices[0]
        //              dp[1][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i])
        //              dp[1][1] = Math.max(dp[i - 1][1], -prices[1]);
        // solution => dp[len - 1][0]
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int[][] dp = new int[3][2];
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i % 3][0] = Math.max(dp[(i - 1) % 3][0], dp[(i - 1) % 3][1] + prices[i]);
            dp[i % 3][1] = Math.max(dp[(i - 1) % 3][1], i == 1 ? -prices[1] : dp[(i - 2) % 3][0] - prices[i]);
        }

        return dp[(len - 1) % 3][0];
    }
}
