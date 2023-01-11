package com.leetcode.solution.dynamicProgramming.matrix.dungeonGame.first;

import com.leetcode.solution.dynamicProgramming.matrix.dungeonGame.CalculateMinimumHPTemplate;

public class CalculateMinimumHP extends CalculateMinimumHPTemplate {
    @Override
    public int calculateMinimumHP(int[][] dungeon) {
        // state => dp[i][j] 表示从右下角到 (i, j) 位置能够存活的最小 HP
        // status function => dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + dungeon[i][j]
        // condition => dp[m][(n, 0]] + dp[(m, 0]][n]
        // solution => dp[0][0]
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) {
            return 0;
        }

        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : (1 - dungeon[m - 1][n - 1]);

        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = calculate(dp[i + 1][n - 1], dungeon[i][n - 1]);
        }
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = calculate(dp[m - 1][j + 1], dungeon[m - 1][j]);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = calculate(Math.min(dp[i + 1][j], dp[i][j + 1]), dungeon[i][j]);
            }
        }

        return dp[0][0];
    }

    private int calculate(int prev, int positionValue) {
        if (positionValue >= 0 && prev <= positionValue) {
            return 1;
        }
        return prev - positionValue;
    }
}
