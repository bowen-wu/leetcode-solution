package com.leetcode.solution.dynamicProgramming.singleSequence.paintHouse.second;

import com.leetcode.solution.dynamicProgramming.singleSequence.paintHouse.MinCostTemplate;

public class MinCost extends MinCostTemplate {
    @Override
    public int minCost(int[][] costs) {
        // [[17,2,17],[16,16,5],[14,3,19]]
        // [[17,2,17],[18,33,7],[21,10,37]]
        // state => dp[i][j] 第i个房子粉刷j颜色所消耗的最小金额
        // status function => dp[i][j] = costs[i][j] + Math.min(dp[i - 1][k]); 其中 k != j
        // condition => dp[0][j] = costs[0][j]
        // solution => Math.min(dp[costs.length - 1][j])
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) {
            return 0;
        }

        int len = costs.length;
        int[][] dp = new int[2][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 3; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (k != j) {
                        min = Math.min(min, dp[(i - 1) % 2][k]);
                    }
                }
                dp[i % 2][j] = costs[i][j] + min;
            }
        }

        return Math.min(Math.min(dp[(len - 1) % 2][0], dp[(len - 1) % 2][1]), dp[(len - 1) % 2][2]);
    }
}
