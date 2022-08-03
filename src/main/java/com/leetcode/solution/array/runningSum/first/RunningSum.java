package com.leetcode.solution.array.runningSum.first;

import com.leetcode.solution.array.runningSum.RunningSumTemplate;

public class RunningSum extends RunningSumTemplate {
    @Override
    public int[] runningSum(int[] nums) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        return prefixSum;
    }
}
