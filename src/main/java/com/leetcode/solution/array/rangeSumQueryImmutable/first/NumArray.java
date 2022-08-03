package com.leetcode.solution.array.rangeSumQueryImmutable.first;

import com.leetcode.solution.array.rangeSumQueryImmutable.RangeSumQueryImmutableTemplate;

public class NumArray extends RangeSumQueryImmutableTemplate {
    private final int[] prefixSum;

    public NumArray(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        this.prefixSum = prefixSum;
    }

    @Override
    public int sumRange(int left, int right) {
        // 时间复杂度：O(1)
        return prefixSum[right + 1] - prefixSum[left];
    }
}
