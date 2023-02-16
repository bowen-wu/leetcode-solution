package com.leetcode.solution.dynamicProgramming.knapsack.combinationSumIV.third;

import com.leetcode.solution.dynamicProgramming.knapsack.combinationSumIV.CombinationSum4Template;

public class CombinationSum4 extends CombinationSum4Template {
    @Override
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < 0) {
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }
}
