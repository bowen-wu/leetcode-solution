package com.leetcode.solution.dynamicProgramming.singleSequence.paintHouseII.first;

import com.leetcode.solution.dynamicProgramming.singleSequence.paintHouseII.MinCostIITemplate;

import java.util.Arrays;

public class MinCostII extends MinCostIITemplate {
    @Override
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int k = costs[0].length;
        int len = costs.length;
        int[][] dp = new int[2][k];
        int minCost = Integer.MAX_VALUE;
        int secondMinCost = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
            if (costs[0][i] <= minCost) {
                secondMinCost = minCost;
                minCost = costs[0][i];
            } else if (costs[0][i] < secondMinCost) {
                secondMinCost = costs[0][i];
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < k; j++) {
                if (dp[(i - 1) % 2][j] == minCost) {
                    dp[i % 2][j] = secondMinCost + costs[i][j];
                } else {
                    dp[i % 2][j] = minCost + costs[i][j];
                }
            }

            minCost = Integer.MAX_VALUE;
            secondMinCost = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (dp[i % 2][j] <= minCost) {
                    secondMinCost = minCost;
                    minCost = dp[i % 2][j];
                } else if (dp[i % 2][j] < secondMinCost) {
                    secondMinCost = dp[i % 2][j];
                }
            }
        }

        return minCost;
    }

    @Override
    public int minCostIIFromI(int[][] costs) {
        // state => dp[i][k] 使用k颜色粉刷第i个房子的最小花费
        // status function => dp[i][k] = min(dp[i - 1][j])(j != k) + cost[i][k]
        // condition => dp[0][k] = cost[0][k] k == 0 -> k
        // solution => min(dp[costs.length - 1][k])
        // 时间复杂度 => O(n * k * k)
        // 空间复杂度 => O(k);
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int k = costs[0].length;
        int len = costs.length;
        int[][] dp = new int[2][k];
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < len; i++) { // n
            Arrays.fill(dp[i % 2], Integer.MAX_VALUE);
            for (int j = 0; j < k; j++) { // k
                for (int l = 0; l < k; l++) { // k
                    if (l != j) {
                        dp[i % 2][j] = Math.min(dp[i % 2][j], dp[(i - 1) % 2][l] + costs[i][j]);
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            result = Math.min(result, dp[(len - 1) % 2][i]);
        }

        return result;
    }
}
