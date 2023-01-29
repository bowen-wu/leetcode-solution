package com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockIII.third;

import com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockIII.MaxProfitTemplate;

public class MaxProfit extends MaxProfitTemplate {
    @Override
    public int maxProfit(int[] prices) {
        // state => dp[i][j][k] 表示第 i 天交易 j 次持股状态为 k 时获取的最大利益
        // status function =>
        //                   dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i])
        //                   dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
        // condition =>
        //              dp[0][[0, j]][0] = 0   dp[0][[0, j]][1] = -prices[0]
        //              dp[[1, i]][0][0] = 0   dp[[1, i]][0][1] = Math.max(-prices[i - 1], -prices[i])
        // solution => dp[len - 1][2][0]
        // 滚动数组优化
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int[][][] dp = new int[len][3][2];
        for (int j = 0; j < 3; j++) {
            dp[0][j][1] = -prices[0];
        }
        for (int i = 1; i < len; i++) {
            dp[i][0][1] = Math.max(dp[i - 1][0][1], -prices[i]);
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < 3; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }

        return dp[len - 1][2][0];
    }

    public int maxProfitWithScrollArray(int[] prices) {
        // 滚动数组优化
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
