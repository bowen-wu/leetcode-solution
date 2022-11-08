package com.leetcode.solution.dynamicProgramming.singleSequence.deleteAndEarn.third;

import com.leetcode.solution.dynamicProgramming.singleSequence.deleteAndEarn.DeleteAndEarnTemplate;

public class DeleteAndEarn extends DeleteAndEarnTemplate {
    @Override
    public int deleteAndEarn(int[] nums) {
        // Ideas: get max => create array for length is max => traversal to acc => 打家劫舍
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int[] accumulate = new int[max + 1];
        for (int i = 0; i < len; i++) {
            accumulate[nums[i]] += nums[i];
        }

        int[] memo = new int[2];
        memo[1] = accumulate[0];
        for (int i = 2; i <= max + 1; i++) {
            memo[i % 2] = Math.max(memo[(i - 1) % 2], memo[(i - 2) % 2] + accumulate[i - 1]);
        }

        return memo[(max + 1) % 2];
    }
}
