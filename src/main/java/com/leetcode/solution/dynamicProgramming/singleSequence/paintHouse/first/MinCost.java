package com.leetcode.solution.dynamicProgramming.singleSequence.paintHouse.first;

import com.leetcode.solution.dynamicProgramming.singleSequence.paintHouse.MinCostTemplate;

import java.util.Arrays;

public class MinCost extends MinCostTemplate {
    @Override
    public int minCost(int[][] costs) {
        // state => dp[i][k] 表示使用k颜色粉刷第i个房子的最小花费
        // status function => dp[i][k] = min(dp[i - 1][j])(j != k) + cost[i][k]
        // condition => dp[0][0] = costs[0][0] dp[0][1] = costs[0][1] dp[0][2] = costs[0][2]
        // solution => min(dp[costs.length][0], dp[costs.length][1], dp[costs.length][2])
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length < 3) {
            return 0;
        }

        int len = costs.length;
        int[][] dp = new int[2][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < len; i++) {
            Arrays.fill(dp[i % 2], Integer.MAX_VALUE);
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < 3; j++) {
                    if (j != k) {
                        dp[i % 2][k] = Math.min(dp[i % 2][k], dp[(i - 1) % 2][j] + costs[i][k]);
                    }
                }
            }
        }

        return Math.min(dp[(len - 1) % 2][0], Math.min(dp[(len - 1) % 2][1], dp[(len - 1) % 2][2]));
    }
}
