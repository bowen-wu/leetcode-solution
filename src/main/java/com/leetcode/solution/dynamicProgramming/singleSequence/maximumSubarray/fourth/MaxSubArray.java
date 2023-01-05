package com.leetcode.solution.dynamicProgramming.singleSequence.maximumSubarray.fourth;

import com.leetcode.solution.dynamicProgramming.singleSequence.maximumSubarray.MaxSubArrayTemplate;

public class MaxSubArray extends MaxSubArrayTemplate {
    @Override
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = nums[0];
        int prev = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (prev >= 0) {
                prev += nums[i];
            } else {
                prev = nums[i];
            }
            result = Math.max(result, prev);
        }

        return result;
    }
}
