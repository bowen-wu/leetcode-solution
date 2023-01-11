package com.leetcode.solution.dynamicProgramming.matrix.minimumPathSum.first;

import com.leetcode.solution.dynamicProgramming.matrix.minimumPathSum.MinPathSumTemplate;

public class MinPathSum extends MinPathSumTemplate {
    @Override
    public int minPathSum(int[][] grid) {
        // state => dp[i][j] 表示左上角到 (i, j) 位置路径最小值
        // status function => dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        // condition => dp[[0, m)][0] & dp[0][[0, n)]
        // solution => dp[m - 1][n - 1]
        // 滚动数组
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[2][n];
        dp[0][0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            dp[i % 2][0] = dp[(i - 1) % 2][0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1]) + grid[i][j];
            }
        }

        return dp[(m - 1) % 2][n - 1];
    }
}
