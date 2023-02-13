package com.leetcode.solution.dynamicProgramming.knapsack.combinationSumIV.second;

import com.leetcode.solution.dynamicProgramming.knapsack.combinationSumIV.CombinationSum4Template;

public class CombinationSum4 extends CombinationSum4Template {
    @Override
    public int combinationSum4(int[] nums, int target) {
        // 完全背包
        // state => dp[i] 表示总和为i的组合个数
        // status function => dp[i] = dp[i] + dp[i - coin]
        // condition => dp[0] = 1
        // solution => dp[target]
        if (nums == null || nums.length == 0 || target < 0) {
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int coin : nums) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }

        return dp[target];
    }
}
