package com.leetcode.solution.dynamicProgramming.matrix.uniquePathsII.second;

import com.leetcode.solution.dynamicProgramming.matrix.uniquePathsII.UniquePathsWithObstaclesTemplate;

public class UniquePathsWithObstacles extends UniquePathsWithObstaclesTemplate {
    @Override
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[2][n];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int j = 1; j < n; j++) {
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            dp[i % 2][0] = obstacleGrid[i][0] == 1 ? 0 : dp[(i - 1) % 2][0];

            for (int j = 1; j < n; j++) {
                dp[i % 2][j] = obstacleGrid[i][j] == 1 ? 0 : (dp[(i - 1) % 2][j] + dp[i % 2][j - 1]);
            }
        }

        return dp[(m - 1) % 2][n - 1];
    }
}
