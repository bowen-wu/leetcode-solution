package com.leetcode.solution.dynamicProgramming.matrix.uniquePaths.third;

import com.leetcode.solution.dynamicProgramming.matrix.uniquePaths.UniquePathsTemplate;

public class UniquePaths extends UniquePathsTemplate {
    @Override
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
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
