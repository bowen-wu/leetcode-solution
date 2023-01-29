package com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeAndSellStockWithCooldown.fourth;

import com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeAndSellStockWithCooldown.MaxProfitTemplate;

public class MaxProfit extends MaxProfitTemplate {
    @Override
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int len = prices.length;
        int[][] dp = new int[3][2];
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(0, prices[1] - prices[0]);
        dp[1][1] = Math.max(-prices[0], -prices[1]);

        for (int i = 2; i < len; i++) {
            dp[i % 3][0] = Math.max(dp[(i - 1) % 3][0], dp[(i - 1) % 3][1] + prices[i]);
            dp[i % 3][1] = Math.max(dp[(i - 1) % 3][1], dp[(i - 2) % 3][0] - prices[i]);
        }

        return dp[(len - 1) % 3][0];
    }
}
