package com.leetcode.solution.dynamicProgramming.matrix.triangle.second;

import com.leetcode.solution.dynamicProgramming.matrix.triangle.MinimumTotalTemplate;

import java.util.List;

public class MinimumTotal extends MinimumTotalTemplate {
    @Override
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0) == null || triangle.get(0).size() == 0) {
            return 0;
        }

        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[2][n];
        dp[0][0] = triangle.get(0).get(0);
        int result = Integer.MAX_VALUE;

        for (int i = 1; i < m; i++) {
            int size = triangle.get(i).size();
            for (int j = 0; j < size; j++) {
                int currentValue = triangle.get(i).get(j);
                if (j == 0) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j] + currentValue;
                } else if (j == size - 1) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + currentValue;
                } else {
                    dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1], dp[(i - 1) % 2][j]) + currentValue;
                }

                if (i == m - 1) {
                    result = Math.min(result, dp[i % 2][j]);
                }
            }
        }

        return result == Integer.MAX_VALUE ? dp[0][0] : result;
    }
}
