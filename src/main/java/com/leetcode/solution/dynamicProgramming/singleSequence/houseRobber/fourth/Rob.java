package com.leetcode.solution.dynamicProgramming.singleSequence.houseRobber.fourth;

import com.leetcode.solution.dynamicProgramming.singleSequence.houseRobber.RobTemplate;

public class Rob extends RobTemplate {
    @Override
    public int rob(int[] nums) {
        // state => dp[i] 表示偷窃到第 i 家的金额
        // status function => dp[i] = Math.max(偷窃i家, 不偷窃i家) = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1])
        // condition => dp[0] = 0 dp[1] = nums[0]
        // solution => dp[nums.length - 1]
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] memo = new int[2];
        memo[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            memo[i % 2] = Math.max(nums[i - 1] + memo[(i - 2) % 2], memo[(i - 1) % 2]);
        }

        return memo[len % 2];
    }
}
