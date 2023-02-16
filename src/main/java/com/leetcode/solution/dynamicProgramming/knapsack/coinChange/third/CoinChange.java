package com.leetcode.solution.dynamicProgramming.knapsack.coinChange.third;

import com.leetcode.solution.dynamicProgramming.knapsack.coinChange.CoinChangeTemplate;

import java.util.Arrays;

public class CoinChange extends CoinChangeTemplate {
    @Override
    public int coinChange(int[] coins, int amount) {
        // 完全背包
        // state => dp[j] 表示凑成金额j的最少硬币数
        // status function => 对于每个硬币 dp[j] = Math.min(dp[j], dp[j - coin] + 1)
        // condition => dp[0] = 0
        // solution => dp[amount]
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChangeFrom01(int[] coins, int amount) {
        // 完全背包
        // state => dp[i][j] 表示前i个硬币金额j的最少硬币数
        // status function => dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - k * coin] + k)
        // condition => dp[0][0] = 0  dp[i][0] = 0  dp[0][j] = ?
        // solution => dp[len][amount]
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }

        int len = coins.length;
        int[][] dp = new int[2][amount + 1];
        dp[0][0] = 0;
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = amount + 1;
        }

        for (int i = 1; i <= len; i++) {
            Arrays.fill(dp[i % 2], amount + 1);
            dp[i % 2][0] = 0;

            for (int j = 1; j <= amount; j++) {
                for (int k = 0; k <= j / coins[i - 1]; k++) {
                    dp[i % 2][j] = Math.min(dp[i % 2][j], dp[(i - 1) % 2][j - k * coins[i - 1]] + k);
                }
            }
        }

        return dp[len % 2][amount] > amount ? -1 : dp[len % 2][amount];
    }
}
