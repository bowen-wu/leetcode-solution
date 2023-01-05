package com.leetcode.solution.dynamicProgramming.singleSequence.maximumProductSubarray.fourth;

import com.leetcode.solution.dynamicProgramming.singleSequence.maximumProductSubarray.MaxProductTemplate;

public class MaxProduct extends MaxProductTemplate {
    @Override
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] positive = new int[len];
        int[] negetive = new int[len];
        positive[0] = nums[0];
        negetive[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                positive[i] = Math.max(nums[i], nums[i] * positive[i - 1]);
                negetive[i] = Math.min(nums[i], nums[i] * negetive[i - 1]);
            } else {
                // nums[i] < 0
                positive[i] = Math.max(nums[i], nums[i] * negetive[i - 1]);
                negetive[i] = Math.min(nums[i], nums[i] * positive[i - 1]);
            }
        }

        int result = nums[0];
        for (int i = 0; i < len; i++) {
            result = Math.max(result, positive[i]);
        }

        return result;
    }
}
