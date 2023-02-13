package com.leetcode.solution.dynamicProgramming.knapsack.partitionEqualSubsetSum.second;

import com.leetcode.solution.dynamicProgramming.knapsack.partitionEqualSubsetSum.CanPartitionTemplate;

public class CanPartition extends CanPartitionTemplate {
    @Override
    public boolean canPartition(int[] nums) {
        // 01背包
        // state => dp[i][j] 表示前i个数字和为j的可能性
        // status function => dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]]
        // condition => dp[i][0] = true  dp[0][j] = false;
        // solution => dp[len][sum / 2]
        if (nums == null || nums.length < 2) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }
        int len = nums.length;
        int max = sum / 2;
        boolean[][] dp = new boolean[2][max + 1];
        dp[0][0] = true;

        for (int i = 1; i < len; i++) {
            dp[i % 2][0] = true;

            for (int j = 1; j <= max; j++) {
                if (j >= nums[i]) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j] || dp[(i - 1) % 2][j - nums[i]];
                } else {
                    dp[i % 2][j] = dp[(i - 1) % 2][j];
                }
            }
        }

        return dp[(len - 1) % 2][sum / 2];
    }
}
