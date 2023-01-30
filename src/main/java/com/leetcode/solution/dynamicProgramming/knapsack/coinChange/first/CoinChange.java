package com.leetcode.solution.dynamicProgramming.knapsack.coinChange.first;

import com.leetcode.solution.dynamicProgramming.knapsack.coinChange.CoinChangeTemplate;

import java.util.Arrays;

public class CoinChange extends CoinChangeTemplate {
    @Override
    public int coinChange(int[] coins, int amount) {
        // state => dp[i][j] 表示前i个硬币凑成金额j的最小硬币数
        // statue function => dp[i][j] = Math.min(dp[i - 1][j - k * coins[i - 1]] + k), 其中 k <= j / coins[i - 1]。相当于选中k个 coins[i - 1]
        // condition => dp[0][0] = 0 dp[i][0] = 0 dp[0][j] = Integer.MAX_VALUE(不可能)
        // solution => dp[len][amount]
        if (amount < 0 || coins == null || coins.length == 0) {
            return -1;
        }

        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = 0;

            for (int j = 1; j <= amount; j++) {
                int currentCoin = coins[i - 1];
                int max = j / currentCoin;
                for (int k = 0; k <= max; k++) {
                    if (dp[i - 1][j - k * currentCoin] + k >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * currentCoin] + k);
                    }
                }
            }
        }

        return dp[len][amount] == Integer.MAX_VALUE ? -1 : dp[len][amount];
    }

    public int coinChangeOptimize(int[] coins, int amount) {
        // state => dp[j] 表示凑成金额j所需要的最小硬币数
        // status function => dp[j] = dp[j - coins[i]] + 1
        // condition => dp[0] = 0 dp[i] = Integer.MAX_VALUE
        // solution => dp[amount]
        if (amount < 0 || coins == null || coins.length == 0) {
            return -1;
        }

        int max = amount + 1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int j = 1; j <= amount; j++) {
            dp[j] = max;
            for (int coin : coins) {
                if (j >= coin) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
