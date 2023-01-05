package com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockII.second;

import com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockII.MaxProfitTemplate;

public class MaxProfit extends MaxProfitTemplate {
    @Override
    public int maxProfitGreedy(int[] prices) {
        // 贪心
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int result = 0;
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                result += prices[i] - prices[i - 1];
            }
        }

        return result;
    }

    @Override
    public int maxProfitDp(int[] prices) {
        // DP
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1] + prices[i]);
            dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], dp[(i - 1) % 2][0] - prices[i]);
        }

        return Math.max(dp[(len - 1) % 2][0], dp[(len - 1) % 2][1]);
    }
}
