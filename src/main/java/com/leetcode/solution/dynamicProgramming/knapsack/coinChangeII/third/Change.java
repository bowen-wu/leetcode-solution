package com.leetcode.solution.dynamicProgramming.knapsack.coinChangeII.third;

import com.leetcode.solution.dynamicProgramming.knapsack.coinChangeII.ChangeTemplate;

import java.util.Arrays;

public class Change extends ChangeTemplate {
    public int change(int amount, int[] coins) {
        // 完全背包 -> 一维数组
        // state => dp[i] 表示凑成金额i的硬币组合数
        // status function => dp[i] += dp[i - coin]
        // condition => dp[0] = 1
        // solution => dp[amount]
        if (coins == null || coins.length == 0 || amount < 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount] > amount ? 0 : dp[amount];
    }

    public int changeScrollArray(int amount, int[] coins) {
        // 完全背包 -> 滚动数组
        if (coins == null || coins.length == 0 || amount < 0) {
            return 0;
        }

        int len = coins.length;
        int[][] dp = new int[2][amount + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= len; i++) {
            Arrays.fill(dp[i % 2], 0);
            dp[i % 2][0] = 1;
            int coin = coins[i - 1];

            for (int j = coin; j <= amount; j++) {
                for (int k = 0; k <= j / coin; k++) {
                    dp[i % 2][j] += dp[(i - 1) % 2][j - k * coin];
                }
            }
        }

        return dp[len % 2][amount];
    }

    public int changeFrom01(int amount, int[] coins) {
        // 完全背包
        // state => dp[i][j] 表示前i个硬币凑成金额j的组合数
        // status function => dp[i][j] = dp[i - 1][j] + dp[i - 1][j - k * coin] + k
        // condition => dp[0][0] = 1 dp[0][j] = 0 dp[i][0] = 1
        // solution => dp[len][amount]
        if (coins == null || coins.length == 0 || amount < 0) {
            return 0;
        }

        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        for (int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= amount; j++) {
                for (int k = 0; k <= j / coins[i - 1]; k++) {
                    dp[i][j] += dp[i - 1][j - k * coins[i - 1]];
                }
            }
        }

        return dp[len][amount];
    }
}
