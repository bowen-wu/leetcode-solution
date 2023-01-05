package com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockIV.second;

import com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockIV.MaxProfitTemplate;

public class MaxProfit extends MaxProfitTemplate {
    @Override
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int[][][] dp = new int[len][k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], j == 0 ? 0 : (dp[i - 1][j - 1][1] + prices[i]));
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }

        return dp[len - 1][k][0];
    }
}
