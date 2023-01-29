package com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockIV.fourth;

import com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockIV.MaxProfitTemplate;

public class MaxProfit extends MaxProfitTemplate {
    @Override
    public int maxProfit(int k, int[] prices) {
        if (k < 1 || prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int[][][] dp = new int[2][k + 1][2];
        for (int j = 0; j <= k; j++) {
            dp[0][j][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            dp[i % 2][0][1] = Math.max(dp[(i - 1) % 2][0][1], -prices[i]);

            for (int j = 1; j <= k; j++) {
                dp[i % 2][j][0] = Math.max(dp[(i - 1) % 2][j][0], dp[(i - 1) % 2][j - 1][1] + prices[i]);
                dp[i % 2][j][1] = Math.max(dp[(i - 1) % 2][j][1], dp[(i - 1) % 2][j][0] - prices[i]);
            }
        }

        return dp[(len - 1) % 2][k][0];
    }
}
