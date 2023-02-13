package com.leetcode.solution.dynamicProgramming.knapsack.coinChangeII.second;

import com.leetcode.solution.dynamicProgramming.knapsack.coinChangeII.ChangeTemplate;

public class Change extends ChangeTemplate {
    @Override
    public int change(int amount, int[] coins) {
        // 完全背包
        // state => dp[i] 表示凑成金额i的组合数
        // status function => dp[i] = dp[i] + dp[i - coin]
        // condition => dp[0] = 1
        // solution => dp[amount]
        if (coins == null || coins.length == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}
