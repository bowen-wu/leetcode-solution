package com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockIII.fourth;

import com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockIII.MaxProfitTemplate;

public class MaxProfit extends MaxProfitTemplate {
    @Override
    public int maxProfit(int[] prices) {
        // state => dp[i][j][k] 表示第i天j笔交易持股状态为k时获取的最大利润
        // status function =>
        //                  dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
        //                  dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
        // condition => dp[0][[0, 2]][0] = 0  dp[0][[0, 2]][1] = -prices[0]
        // solution => dp[prices.length - 1][2][0]
        // 滚动数组
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int[][][] dp = new int[2][3][2];
        for (int j = 0; j < 3; j++) {
            dp[0][j][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            dp[i % 2][0][1] = Math.max(dp[(i - 1) % 2][0][1], -prices[i]);

            for (int j = 1; j < 3; j++) {
                dp[i % 2][j][0] = Math.max(dp[(i - 1) % 2][j][0], dp[(i - 1) % 2][j - 1][1] + prices[i]);
                dp[i % 2][j][1] = Math.max(dp[(i - 1) % 2][j][1], dp[(i - 1) % 2][j][0] - prices[i]);
            }
        }

        return dp[(len - 1) % 2][2][0];
    }
}
