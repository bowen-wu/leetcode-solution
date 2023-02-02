package com.leetcode.solution.dynamicProgramming.matrix.maximalSquare.first;

import com.leetcode.solution.dynamicProgramming.matrix.maximalSquare.MaximalSquareTemplate;

public class MaximalSquare extends MaximalSquareTemplate {
    @Override
    public int maximalSquare(char[][] matrix) {
        // state => dp[i][j] 表示以(i, j)为右下角值全为1的正方形边长最大值
        // status function => dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
        // condition => dp[i][0] = matrix[i][0] dp[0][j] = matrix[0][j]
        // solution => Math.max(dp[i][j])^2
        // 滚动数组
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[2][n];
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i % 2][j] = 1;
                    } else {
                        dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1], Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1])) + 1;
                    }
                    max = Math.max(max, dp[i % 2][j]);
                } else {
                    dp[i % 2][j] = 0;
                }
            }
        }

        return max * max;
    }
}
