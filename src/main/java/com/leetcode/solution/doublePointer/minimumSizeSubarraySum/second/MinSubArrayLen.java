package com.leetcode.solution.doublePointer.minimumSizeSubarraySum.second;

import com.leetcode.solution.doublePointer.minimumSizeSubarraySum.MinSubArrayLenTemplate;

public class MinSubArrayLen extends MinSubArrayLenTemplate {
    @Override
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && sum < target) {
                sum += nums[j];
                j++;
            }

            if (sum >= target && j - i < result) {
                result = j - i;
            }
            sum -= nums[i];
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
