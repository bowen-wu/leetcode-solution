package com.leetcode.solution.dynamicProgramming.matrix.dungeonGame.third;

import com.leetcode.solution.dynamicProgramming.matrix.dungeonGame.CalculateMinimumHPTemplate;

public class CalculateMinimumHP extends CalculateMinimumHPTemplate {
    @Override
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) {
            return 1;
        }

        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : 1 - dungeon[m - 1][n - 1];
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = getHP(dungeon[i][n - 1], dp[i + 1][n - 1]);
        }
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = getHP(dungeon[m - 1][j], dp[m - 1][j + 1]);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(getHP(dungeon[i][j], dp[i + 1][j]), getHP(dungeon[i][j], dp[i][j + 1]));
            }
        }

        return dp[0][0];
    }

    public int calculateMinimumHPForScrollArray(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) {
            return 1;
        }

        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[2][n];
        int last = (m - 1) % 2;
        dp[last][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : 1 - dungeon[m - 1][n - 1];

        for (int j = n - 2; j >= 0; j--) {
            dp[last][j] = getHP(dungeon[m - 1][j], dp[last][j + 1]);
        }

        for (int i = m - 2; i >= 0; i--) {
            dp[i % 2][n - 1] = getHP(dungeon[i][n - 1], dp[(i + 1) % 2][n - 1]);

            for (int j = n - 2; j >= 0; j--) {
                dp[i % 2][j] = Math.min(getHP(dungeon[i][j], dp[(i + 1) % 2][j]), getHP(dungeon[i][j], dp[i % 2][j + 1]));
            }
        }

        return dp[0][0];
    }

    private int getHP(int cost, int remaining) {
        if (cost >= 0) {
            if (cost >= remaining) {
                return 1;
            }
            return remaining - cost;
        }
        return remaining - cost;
    }

}
