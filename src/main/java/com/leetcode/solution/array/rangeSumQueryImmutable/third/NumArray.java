package com.leetcode.solution.array.rangeSumQueryImmutable.third;

import com.leetcode.solution.array.rangeSumQueryImmutable.RangeSumQueryImmutableTemplate;

public class NumArray extends RangeSumQueryImmutableTemplate {
    // 思路：数组前缀和 => interval[i, j] = prefixSum[j + 1] - prefixSum[i]
    private final int[] prefixSum;

    public NumArray(int[] nums) {
        // O(n) + O(n)
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("The param of nums is invalid!");
        }
        prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    @Override
    public int sumRange(int left, int right) {
        // O(1)
        return prefixSum[right + 1] - prefixSum[left];
    }
}
