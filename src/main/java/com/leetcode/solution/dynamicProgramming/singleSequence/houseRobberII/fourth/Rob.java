package com.leetcode.solution.dynamicProgramming.singleSequence.houseRobberII.fourth;

import com.leetcode.solution.dynamicProgramming.singleSequence.houseRobberII.RobTemplate;

public class Rob extends RobTemplate {
    @Override
    public int rob(int[] nums) {
        // 做两次打家劫舍
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;

        // corn case
        if (len == 1) {
            return nums[0];
        }

        int[] memo = new int[2];
        memo[0] = 0;
        memo[1] = nums[0];

        // 1打劫第一家到倒数第二家
        for (int i = 2; i < len; i++) {
            memo[i % 2] = Math.max(nums[i - 1] + memo[(i - 2) % 2], memo[(i - 1) % 2]);
        }

        int currentMax = memo[(len - 1) % 2];

        // 2打劫第二家到最后一家
        memo[0] = 0;
        memo[1] = 0;
        for (int i = 2; i <= len; i++) {
            memo[i % 2] = Math.max(nums[i - 1] + memo[(i - 2) % 2], memo[(i - 1) % 2]);
        }

        return Math.max(currentMax, memo[len % 2]);
    }
}
