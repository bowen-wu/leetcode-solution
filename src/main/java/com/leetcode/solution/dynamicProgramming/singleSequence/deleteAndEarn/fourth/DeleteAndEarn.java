package com.leetcode.solution.dynamicProgramming.singleSequence.deleteAndEarn.fourth;

import com.leetcode.solution.dynamicProgramming.singleSequence.deleteAndEarn.DeleteAndEarnTemplate;

public class DeleteAndEarn extends DeleteAndEarnTemplate {
    @Override
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] cost = new int[max + 1];
        for (int i = 0; i < len; i++) {
            cost[nums[i]] += nums[i];
        }

        int[] memo = new int[2];
        memo[1] = cost[1];

        for (int i = 2; i <= max; i++) {
            memo[i % 2] = Math.max(cost[i] + memo[(i - 2) % 2], memo[(i - 1) % 2]);
        }

        return memo[max % 2];
    }
}
