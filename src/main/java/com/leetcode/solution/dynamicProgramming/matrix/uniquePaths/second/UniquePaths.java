package com.leetcode.solution.dynamicProgramming.matrix.uniquePaths.second;

import com.leetcode.solution.dynamicProgramming.matrix.uniquePaths.UniquePathsTemplate;

public class UniquePaths extends UniquePathsTemplate {
    @Override
    public int uniquePaths(int m, int n) {
        // state => dp[i][j]表示 start 到位置 (i, j) 的路径数
        // status function => dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        // condition => dp[i][0] = 1 dp[0][j] = 1
        // solution => dp[m][n]
        if (m < 1 || n < 1) {
            return 0;
        }

        int[][] dp = new int[2][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            dp[i % 2][0] = 1;

            for (int j = 1; j < n; j++) {
                dp[i % 2][j] = dp[(i - 1) % 2][j] + dp[i % 2][j - 1];
            }
        }

        return dp[(m - 1) % 2][n - 1];
    }
}
