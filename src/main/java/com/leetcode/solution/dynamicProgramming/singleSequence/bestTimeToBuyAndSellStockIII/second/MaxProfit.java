package com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockIII.second;

import com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockIII.MaxProfitTemplate;

public class MaxProfit extends MaxProfitTemplate {
    @Override
    public int maxProfit(int[] prices) {
        // state => dp[i][j][k] 第i天经过j笔交易持股状态k的情况下的余额
        // status function =>
        //                  dp[i][j][0] = Math.max(dp[i - 1][j][0], j == 0 ? 0 : dp[i - 1][j - 1][1] + prices[i]);
        //                  dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
        // condition => dp[0][0][0] = 0          dp[0][1][0] = 0
        //              dp[0][0][1] = -prices[0] dp[0][1][1] = 0
        // solution => Math.max(dp[len - 1][j][0]) j = 0, 1, 2
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int[][][] dp = new int[len][3][2];
        dp[0][0][1] = -prices[0];
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= 2; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], j == 0 ? 0 : (dp[i - 1][j - 1][1] + prices[i]));
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }

        return dp[len - 1][2][0];
    }
}
