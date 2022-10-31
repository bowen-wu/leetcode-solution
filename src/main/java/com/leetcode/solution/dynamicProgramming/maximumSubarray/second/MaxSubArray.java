package com.leetcode.solution.dynamicProgramming.maximumSubarray.second;

import com.leetcode.solution.dynamicProgramming.maximumSubarray.MaxSubArrayTemplate;

public class MaxSubArray extends MaxSubArrayTemplate {
    @Override
    public int maxSubArray(int[] nums) {
        // state => f(n) 以 nums[n] 结尾的最大子数组和
        // status function => f(n) = f(n - 1) > 0 ? nums[i] + f(n - 1) : nums[i]
        // condition => x
        // solution => f(n) max
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int prevSum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int newSum = nums[i];
            if (prevSum > 0) {
                newSum += prevSum;
            }
            max = Math.max(max, newSum);
            prevSum = newSum;
        }

        return max;
    }
}
