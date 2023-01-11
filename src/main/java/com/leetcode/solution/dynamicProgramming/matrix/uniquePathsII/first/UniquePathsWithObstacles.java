package com.leetcode.solution.dynamicProgramming.matrix.uniquePathsII.first;

import com.leetcode.solution.dynamicProgramming.matrix.uniquePathsII.UniquePathsWithObstaclesTemplate;

public class UniquePathsWithObstacles extends UniquePathsWithObstaclesTemplate {
    @Override
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // state => dp[i][j] 表示左上角到 (i, j) 点的路径数
        // status function => dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : (dp[i - 1][j] + dp[i][j - 1])
        // condition => dp[[0, m)][0] = 1 dp[0][[0, n)] = 1 + 查看是否是 1, 如果是1，后面的都是0
        // solution => dp[m - 1][n - 1]
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : (dp[i - 1][j] + dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
}
