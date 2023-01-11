package com.leetcode.solution.dynamicProgramming.matrix.uniquePaths.first;

import com.leetcode.solution.dynamicProgramming.matrix.uniquePaths.UniquePathsTemplate;

public class UniquePaths extends UniquePathsTemplate {
    @Override
    public int uniquePaths(int m, int n) {
        // state => dp[i][j] 代表从左上角到 (i, j) 位置的路径总数
        // status function => dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        // condition => dp[0][[0, n)] = 1 & dp[[0, m)][0] = 1
        // solution => dp[m - 1][n - 1]
        if (m < 0 || n < 0) {
            return 0;
        }

        int[][] dp = new int[2][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        dp[1][0] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i % 2][j] = dp[(i - 1) % 2][j] + dp[i % 2][j - 1];
            }
        }

        return dp[(m - 1) % 2][n - 1];
    }
}
