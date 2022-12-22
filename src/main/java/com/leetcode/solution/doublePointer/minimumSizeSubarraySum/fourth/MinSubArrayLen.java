package com.leetcode.solution.doublePointer.minimumSizeSubarraySum.fourth;

import com.leetcode.solution.doublePointer.minimumSizeSubarraySum.MinSubArrayLenTemplate;

public class MinSubArrayLen extends MinSubArrayLenTemplate {
    @Override
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int j = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            while (j < len && sum < target) {
                sum += nums[j];
                j++;
            }

            if (sum >= target && result > j - i) {
                result = j - i;
            }
            sum -= nums[i];
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
