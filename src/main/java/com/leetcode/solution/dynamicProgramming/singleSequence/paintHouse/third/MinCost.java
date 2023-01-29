package com.leetcode.solution.dynamicProgramming.singleSequence.paintHouse.third;

import com.leetcode.solution.dynamicProgramming.singleSequence.paintHouse.MinCostTemplate;

import java.util.Arrays;

public class MinCost extends MinCostTemplate {
    @Override
    public int minCost(int[][] costs) {
        // state => dp[i][j] 表示到第 i 个房子粉刷 j 颜色时的最小花费
        // status function => dp[i][j] = Math(dp[i - 1][m], dp[i - 1][n]) + costs[i][j]
        // condition => dp[0][[0 , 3]]
        // solution => Math.min(dp[len - 1][[0, 3]])
        // 滚动数组优化
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) {
            return 0;
        }

        int len = costs.length;
        int[][] dp = new int[len][3];
        for (int j = 0; j < 3; j++) {
            dp[0][j] = costs[0][j];
        }

        for (int i = 1; i < len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (k != j) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + costs[i][j]);
                    }
                }
            }
        }

        return Math.min(Math.min(dp[len - 1][0], dp[len - 1][1]), dp[len - 1][2]);
    }

    public int minCostWithScrollArray(int[][] costs) {
        // state => dp[i][j] 表示到第 i 个房子粉刷 j 颜色时的最小花费
        // status function => dp[i][j] = Math(dp[i - 1][m], dp[i - 1][n]) + costs[i][j]
        // condition => dp[0][[0 , 3]]
        // solution => Math.min(dp[len - 1][[0, 3]])
        // 滚动数组优化
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) {
            return 0;
        }

        int len = costs.length;
        int[][] dp = new int[2][3];
        for (int j = 0; j < 3; j++) {
            dp[0][j] = costs[0][j];
        }

        for (int i = 1; i < len; i++) {
            Arrays.fill(dp[i % 2], Integer.MAX_VALUE);

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (k != j) {
                        dp[i % 2][j] = Math.min(dp[i % 2][j], dp[(i - 1) % 2][k] + costs[i][j]);
                    }
                }
            }
        }

        return Math.min(Math.min(dp[(len - 1) % 2][0], dp[(len - 1) % 2][1]), dp[(len - 1) % 2][2]);
    }

    public int minCostWithScrollArrayAndMinValue(int[][] costs) {
        // state => dp[i][j] 表示到第 i 个房子粉刷 j 颜色时的最小花费
        // status function => dp[i][j] = Math(dp[i - 1][m], dp[i - 1][n]) + costs[i][j]
        // condition => dp[0][[0 , 3]]
        // solution => Math.min(dp[len - 1][[0, 3]])
        // 滚动数组优化
        // 记录最小值和第二小值
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) {
            return 0;
        }

        int len = costs.length;
        int[][] dp = new int[2][3];
        int min = Math.min(costs[0][0], costs[0][1]);
        int secondMin = Math.max(costs[0][0], costs[0][1]);
        int currentValue = costs[0][2];
        if (currentValue < min) {
            secondMin = min;
            min = currentValue;
        } else if (currentValue < secondMin) {
            secondMin = currentValue;
        }
        for (int j = 0; j < 3; j++) {
            dp[0][j] = costs[0][j];
        }

        for (int i = 1; i < len; i++) {
            int currentMin = Integer.MAX_VALUE;
            int currentSecondMin = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                dp[i % 2][j] = (dp[(i - 1) % 2][j] == min ? secondMin : min) + costs[i][j];
                if (dp[i % 2][j] < currentMin) {
                    currentSecondMin = currentMin;
                    currentMin = dp[i % 2][j];
                } else if (dp[i % 2][j] < currentSecondMin) {
                    currentSecondMin = dp[i % 2][j];
                }
            }
            min = currentMin;
            secondMin = currentSecondMin;
        }

        return min;
    }
}
