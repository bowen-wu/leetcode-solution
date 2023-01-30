package com.leetcode.solution.dynamicProgramming.knapsack.coinChangeII.first;

import com.leetcode.solution.dynamicProgramming.knapsack.coinChangeII.ChangeTemplate;

public class Change extends ChangeTemplate {
    @Override
    public int change(int amount, int[] coins) {
        // state => dp[i] 表示凑成金额i的方案总数
        // status function => dp[i] = sum(dp[i - coins[j]])
        // condition => dp[0] = 1
        // solution => dp[amount]
        if (amount < 0 || coins == null || coins.length == 0) {
            return 0;
        }

        // amount = 5, coins = [1, 2, 5]
        // coin 1 2 5
        // dp[0] = 1
        // dp[1] = 1
        // dp[2] = 1 + 1
        // dp[3] = 1 + 1
        // dp[4] = 1 + 2
        // dp[5] = 1 + 2 + 1
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        // 先遍历硬币，放置重复
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}
