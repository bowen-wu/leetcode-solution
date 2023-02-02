package com.leetcode.solution.dynamicProgramming.matrix.dungeonGame.second;

import com.leetcode.solution.dynamicProgramming.matrix.dungeonGame.CalculateMinimumHPTemplate;

public class CalculateMinimumHP extends CalculateMinimumHPTemplate {
    @Override
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) {
            return -1;
        }

        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[2][n];
        dp[(m - 1) % 2][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1: 1 - dungeon[m - 1][n - 1];

        for (int j = n - 2; j >= 0; j--) {
            dp[(m - 1) % 2][j] = calculateHP(dp[(m - 1) % 2][j + 1] - dungeon[m - 1][j]);
        }

        for (int i = m - 2; i >= 0; i--) {
            dp[i % 2][n - 1] = calculateHP(dp[(i + 1) % 2][n - 1] - dungeon[i][n - 1]);

            for (int j = n - 2; j >= 0; j--) {
                dp[i % 2][j] = calculateHP(Math.min(dp[(i + 1) % 2][j], dp[i % 2][j + 1]) - dungeon[i][j]);
            }
        }

        return dp[0][0];
    }

    private int calculateHP(int currentHP) {
        return currentHP <= 0 ? 1 : currentHP;
    }
}
