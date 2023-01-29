package com.leetcode.solution.dynamicProgramming.singleSequence.paintHouseII.third;

import com.leetcode.solution.dynamicProgramming.singleSequence.paintHouseII.MinCostIITemplate;

public class MinCostII extends MinCostIITemplate {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) {
            return 0;
        }

        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[2][k];
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            int currentValue = costs[0][j];
            dp[0][j] = currentValue;
            if (currentValue <= min) {
                secondMin = min;
                min = currentValue;
            } else if (currentValue < secondMin) {
                secondMin = currentValue;
            }
        }

        for (int i = 1; i < n; i++) {
            int currentMin = Integer.MAX_VALUE;
            int currentSecondMin = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                dp[i % 2][j] = (dp[(i - 1) % 2][j] == min ? secondMin : min) + costs[i][j];
                if (dp[i % 2][j] <= currentMin) {
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

    @Override
    public int minCostIIFromI(int[][] costs) {
        return 0;
    }
}
