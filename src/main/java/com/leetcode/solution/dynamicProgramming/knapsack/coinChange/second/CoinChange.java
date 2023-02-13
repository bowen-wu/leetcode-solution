package com.leetcode.solution.dynamicProgramming.knapsack.coinChange.second;

import com.leetcode.solution.dynamicProgramming.knapsack.coinChange.CoinChangeTemplate;

public class CoinChange extends CoinChangeTemplate {
    @Override
    public int coinChange(int[] coins, int amount) {
        // 完全背包
        // state => dp[i][j] 表示前i个硬币凑成金额j的最少硬币数
        // status function => dp[i][j] = Math.min(dp[i - 1][j - k * coins[i]] + k)
        // condition => dp[i][0] = 0 dp[0][j]
        // solution => dp[len][amount]
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }

        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = amount + 1;
        }


        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = amount + 1;
                int max = j / coins[i - 1];
                for (int k = 0; k <= max; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * coins[i - 1]] + k);
                }
            }
        }

        return dp[len][amount] == amount + 1 ? -1 : dp[len][amount];
    }

    public int coinChangeSpaceOptimize(int[] coins, int amount) {
        // 完全背包
        // state => dp[j] 表示凑成金额j的最少硬币数
        // status function => dp[j] = Math.min(dp[j - coin] + 1)
        // condition => dp[0] = 0
        // solution => dp[amount]
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];

        for (int j = 1; j <= amount; j++) {
            dp[j] = amount + 1;
            for (int coin : coins) {
                if (j >= coin && dp[j - coin] + 1 > 0) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
