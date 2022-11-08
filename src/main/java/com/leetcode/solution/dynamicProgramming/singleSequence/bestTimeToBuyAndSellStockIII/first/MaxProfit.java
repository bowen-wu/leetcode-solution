package com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockIII.first;

import com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockIII.MaxProfitTemplate;

public class MaxProfit extends MaxProfitTemplate {
    @Override
    public int maxProfit(int[] prices) {
        // 1. state => dp[i][j][l] 表示第i天之后经历了j次交易手中持股状态为l的收益 => l = 0 | 1
        // 2. status function => dp[i][j][l] => 卖出才算一笔交易
        //     1. 第i天交易了
        //         1. 买入 => dp[i][j][1] = dp[i - 1][j][0] - prices[i]
        //         2. 卖出 => dp[i][j][0] = dp[i - 1][j - 1][1] + prices[i]
        //     2. 第i天没有交易 => dp[i][j][0] = dp[i - 1][j][0] & dp[i][j][1] = dp[i - 1][j][1]
        // 3. condition => i == 0 -> len & j == 0 -> 2
        //     1. dp[0][0][0] = 0
        //     2. dp[0][0][1] = -prices[0]
        // 4. solution => get dp[prices.length][2][0]
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int[][][] dp = new int[len][3][2];

        for (int j = 0; j <= 2; j++) {
            dp[0][j][0] = 0;
            dp[0][j][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
        }


        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= 2; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j - 1][1] + prices[i], dp[i - 1][j][0]);
                dp[i][j][1] = Math.max(dp[i - 1][j][0] - prices[i], dp[i - 1][j][1]);
            }
        }

        return dp[len - 1][2][0];
    }
}
