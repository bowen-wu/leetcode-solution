package com.leetcode.solution.doublePointer.minimumSizeSubarraySum.first;

import com.leetcode.solution.doublePointer.minimumSizeSubarraySum.MinSubArrayLenTemplate;

public class MinSubArrayLen extends MinSubArrayLenTemplate {
    @Override
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // double pointer
        int i = 0;
        int j = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        for (i = 0; i < nums.length; i++) {
            while (j < nums.length) {
                if (sum < target) {
                    sum += nums[j];
                    j++;
                } else {
                    break;
                }
            }

            // 收窄 & update result
            if (sum >= target && (j - i < len)) {
                len = Math.min(len, j - i);
            }
            sum -= nums[i];
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
