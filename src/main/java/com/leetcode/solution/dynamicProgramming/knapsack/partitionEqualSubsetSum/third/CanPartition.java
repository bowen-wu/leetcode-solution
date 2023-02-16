package com.leetcode.solution.dynamicProgramming.knapsack.partitionEqualSubsetSum.third;

import com.leetcode.solution.dynamicProgramming.knapsack.partitionEqualSubsetSum.CanPartitionTemplate;

public class CanPartition extends CanPartitionTemplate {
    @Override
    public boolean canPartition(int[] nums) {
        // 01背包
        // state => dp[i][j] 表示前i个数字和为j的可能性
        // status function => dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num]
        // condition => dp[0][0] = true   dp[0][j] = false  dp[i][0] = true
        // solution => dp[len - 1][target]
        if (nums == null || nums.length == 0) {
            return false;
        }

        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[2][target + 1];
        dp[0][0] = true;
        for (int j = 1; j <= target; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < len; i++) {
            dp[i % 2][0] = true;

            for (int j = 1; j <= target; j++) {
                if (j >= nums[i]) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j] || dp[(i - 1) % 2][j - nums[i]];
                } else {
                    dp[i % 2][j] = dp[(i - 1) % 2][j];
                }
            }
        }

        return dp[(len - 1) % 2][target];
    }

    public boolean canPartitionOneArray(int[] nums) {
        // 01背包 => 空间优化到一个数组需要从后往前计算 => 当前值根据之前的值计算得出，如果从前往后，则会丢失信息
        // state => dp[i] 表示前j个数字中和为i的可能性
        // status function => dp[i] = dp[i] || dp[i - num]
        // condition => dp[0] = true
        // solution => dp[target]
        if (nums == null || nums.length == 0) {
            return false;
        }

        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];
    }
}
