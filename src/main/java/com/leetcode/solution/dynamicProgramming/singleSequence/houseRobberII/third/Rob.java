package com.leetcode.solution.dynamicProgramming.singleSequence.houseRobberII.third;

import com.leetcode.solution.dynamicProgramming.singleSequence.houseRobberII.RobTemplate;

public class Rob extends RobTemplate {
    @Override
    public int rob(int[] nums) {
        // Ideas: 偷窃第一家到第 n - 1 家 | 偷窃第二家
        // state => f(n) 偷窃到第 n 家偷窃的最高金额
        // status function => f(n) = Math.max(f(n - 1), f(n - 2) + nums[n - 1])
        // condition => f(0) = 0 f(1) = nums[0]
        // solution => get f(nums.length)
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;

        // core case
        if (len == 1) {
            return nums[0];
        }

        int[] memo = new int[2];
        memo[1] = nums[0];

        // 1 -> n - 1
        for (int i = 2; i < len; i++) {
            memo[i % 2] = Math.max(memo[(i - 1) % 2], memo[(i - 2) % 2] + nums[i - 1]);
        }

        int result = memo[(len - 1) % 2];

        // 2 -> n
        memo[0] = 0;
        memo[1] = 0;
        for (int i = 2; i <= len; i++) {
            memo[i % 2] = Math.max(memo[(i - 1) % 2], memo[(i - 2) % 2] + nums[i - 1]);
        }

        return Math.max(result, memo[len % 2]);
    }
}
