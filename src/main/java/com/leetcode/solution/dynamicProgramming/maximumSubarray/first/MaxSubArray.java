package com.leetcode.solution.dynamicProgramming.maximumSubarray.first;

import com.leetcode.solution.dynamicProgramming.maximumSubarray.MaxSubArrayTemplate;

public class MaxSubArray extends MaxSubArrayTemplate {
    @Override
    public int maxSubArray(int[] nums) {
        // check input
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int prevState = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currentState = prevState > 0 ? (nums[i] + prevState) : nums[i];
            max = Math.max(max, currentState);
            prevState = currentState;
        }
        return max;
    }
}
