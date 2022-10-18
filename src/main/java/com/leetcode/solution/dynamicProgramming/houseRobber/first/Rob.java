package com.leetcode.solution.dynamicProgramming.houseRobber.first;

import com.leetcode.solution.dynamicProgramming.houseRobber.RobTemplate;

public class Rob extends RobTemplate {
    @Override
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // memo[i] 代表到第 i 个房子时偷窃到的最高金额
        int[] memo = new int[2];
        memo[1] = nums[0];

        // Function => memo[i] = Math.max(偷窃前一个房间，偷窃当前房间)
        for (int i = 2; i <= nums.length; i++) {
            memo[i % 2] = Math.max(memo[(i - 1) % 2], memo[(i - 2) % 2] + nums[i - 1]);
        }
        return memo[nums.length % 2];
    }
}
