package com.leetcode.solution.dynamicProgramming.maximumProductSubarray.first;

import com.leetcode.solution.dynamicProgramming.maximumProductSubarray.MaxProductTemplate;

public class MaxProduct extends MaxProductTemplate {
    @Override
    public int maxProduct(int[] nums) {
        // check input
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int max = maxDp[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                maxDp[i] = maxDp[i - 1] > 0 ? maxDp[i - 1] * nums[i] : nums[i];
                minDp[i] = minDp[i - 1] < 0 ? minDp[i - 1] * nums[i] : nums[i];
            } else if (nums[i] < 0) {
                maxDp[i] = minDp[i - 1] < 0 ? minDp[i - 1] * nums[i] : nums[i];
                minDp[i] = maxDp[i - 1] > 0 ? maxDp[i - 1] * nums[i] : nums[i];
            }
            max = Math.max(max, maxDp[i]);
        }

        return max;
    }

    public int maxProductScrollArray(int[] nums) {
        // check input
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int prevMinState = nums[0];
        int prevMaxState = nums[0];
        int max = prevMaxState;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                prevMaxState = prevMaxState > 0 ? prevMaxState * nums[i] : nums[i];
                prevMinState = prevMinState < 0 ? prevMinState * nums[i] : nums[i];
            } else {
                // nums[i] < 0
                int temp = prevMaxState;
                prevMaxState = prevMinState < 0 ? prevMinState * nums[i] : nums[i];
                prevMinState = temp > 0 ? temp * nums[i] : nums[i];
            }
            max = Math.max(max, prevMaxState);
        }
        return max;
    }
}
