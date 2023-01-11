package com.leetcode.solution.dynamicProgramming.matrix.triangle.first;

import com.leetcode.solution.dynamicProgramming.matrix.triangle.MinimumTotalTemplate;

import java.util.List;

public class MinimumTotal extends MinimumTotalTemplate {
    @Override
    public int minimumTotal(List<List<Integer>> triangle) {
        // state => dp[i][j] 表示顶点到 (i, j) 位置的最小路径和
        // status function => dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j] => check i - 1 & j - 1
        // condition => dp[0][0] = triangle[0][0]
        // solution => Math.min(dp[len])
        if (triangle == null || triangle.size() == 0 || triangle.get(0) == null || triangle.get(0).size() == 0) {
            return 0;
        }

        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[2][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            int len = triangle.get(i).size();
            for (int j = 0; j < len; j++) {
                if (j == 0) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j] + triangle.get(i).get(j);
                } else if (j == len - 1) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j], dp[(i - 1) % 2][j - 1]) + triangle.get(i).get(j);
                }
            }
        }

        int min = dp[(m - 1) % 2][0];
        for (int j = 1; j < n; j++) {
            min = Math.min(min, dp[(m - 1) % 2][j]);
        }

        return min;
    }
}
