package com.leetcode.solution.dynamicProgramming.singleSequence.maximumSubarray.third;

import com.leetcode.solution.dynamicProgramming.singleSequence.maximumSubarray.MaxSubArrayTemplate;

public class MaxSubArray extends MaxSubArrayTemplate {
    @Override
    public int maxSubArray(int[] nums) {
        // state => f(n) 表示以 nums[n] 为结尾的连续子数组的最大值
        // status function => f(n) = f(n - 1) > 0 ? f(n - 1) + nums[n] : nums[n]
        // condition => x
        // solution => get Math.max(f(n)) n == 0 -> nums.length
        // [-2, 1, -3, 4, -1, 2, 1, -5, 4]
        // [-2, 1, -2, 4, 3, 5, 6, 1, 5]
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int prevSum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            prevSum = prevSum > 0 ? prevSum + nums[i] : nums[i];
            max = Math.max(max, prevSum);
        }

        return max;
    }
}
