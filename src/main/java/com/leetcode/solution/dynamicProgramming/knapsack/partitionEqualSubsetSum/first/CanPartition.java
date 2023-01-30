package com.leetcode.solution.dynamicProgramming.knapsack.partitionEqualSubsetSum.first;

import com.leetcode.solution.dynamicProgramming.knapsack.partitionEqualSubsetSum.CanPartitionTemplate;

public class CanPartition extends CanPartitionTemplate {
    @Override
    public boolean canPartition(int[] nums) {
        // state => dp[i][j] 表示从前i个数字中选择和为j是否存在
        // status function => dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j]
        // condition => dp[0][0] = true dp[i][0] = true dp[0][j] = false
        // solution => dp[len][sum/2]
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
        int target = sum / 2;
        boolean[][] dp = new boolean[2][target + 1];
        dp[0][0] = true;

        for (int i = 1; i < len; i++) {
            dp[i % 2][0] = true;

            for (int j = 1; j <= target; j++) {
                dp[i % 2][j] = (j >= nums[i] && dp[(i - 1) % 2][j - nums[i]]) || dp[(i - 1) % 2][j];
            }
        }

        return dp[(len - 1) % 2][target];
    }
}
