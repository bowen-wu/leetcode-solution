package com.leetcode.solution.dynamicProgramming.singleSequence.paintHouseII.second;

import com.leetcode.solution.dynamicProgramming.singleSequence.paintHouseII.MinCostIITemplate;

public class MinCostII extends MinCostIITemplate {
    @Override
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) {
            return 0;
        }

        int len = costs.length;
        int length = costs[0].length;
        int[][] dp = new int[2][length];
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            dp[0][i] = costs[0][i];
            if (costs[0][i] <= min) {
                secondMin = min;
                min = costs[0][i];
            } else if (costs[0][i] < secondMin) {
                secondMin = costs[0][i];
            }
        }

        for (int i = 1; i < len; i++) {
            int tempMin = Integer.MAX_VALUE;
            int tempSecondMin = Integer.MAX_VALUE;
            for (int j = 0; j < length; j++) {
                if (dp[(i - 1) % 2][j] == min) {
                    dp[i % 2][j] = costs[i][j] + secondMin;
                } else {
                    dp[i % 2][j] = costs[i][j] + min;
                }

                if (dp[i % 2][j] <= tempMin) {
                    tempSecondMin = tempMin;
                    tempMin = dp[i % 2][j];
                } else if (dp[i % 2][j] < tempSecondMin) {
                    tempSecondMin = dp[i % 2][j];
                }
            }
            min = tempMin;
            secondMin = tempSecondMin;
        }

        return min;
    }

    @Override
    public int minCostIIFromI(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) {
            return 0;
        }

        int len = costs.length;
        int length = costs[0].length;
        int[][] dp = new int[2][length];
        for (int i = 0; i < length; i++) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < length; k++) {
                    if (k != j) {
                        min = Math.min(min, dp[(i - 1) % 2][k]);
                    }
                }
                dp[i % 2][j] = costs[i][j] + min;
            }
        }

        int result = dp[(len - 1) % 2][0];
        for (int i = 1; i < length; i++) {
            result = Math.min(result, dp[(len - 1) % 2][i]);
        }
        return result;
    }
}
