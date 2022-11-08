package com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockIV.first;

import com.leetcode.solution.dynamicProgramming.singleSequence.bestTimeToBuyAndSellStockIV.MaxProfitTemplate;

public class MaxProfit extends MaxProfitTemplate {
    @Override
    public int maxProfit(int k, int[] prices) {
        // state => dp[i][j][l] 表示第i天j次交易后持股状态为l情况下获取的最大利益 => l = 0 | 1
        // status function =>
        //                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i])
        //                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i])
        // condition =>
        //              dp[0][j][0] => j = 0 -> k
        //              dp[i][0][0] => i = 0 -> prices.length
        // solution => get dp[prices.length - 1][k][0]
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int[][][] dp = new int[len][k + 1][2];
        for (int j = 0; j <= k; j++) {
            dp[0][j][0] = 0;
            dp[0][j][1] = -prices[0];
        }
        for (int i = 1; i < len; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }

        return dp[len - 1][k][0];
    }
}
