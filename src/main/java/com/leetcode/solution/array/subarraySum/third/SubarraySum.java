package com.leetcode.solution.array.subarraySum.third;

import com.leetcode.solution.array.subarraySum.SubarraySumTemplate;

public class SubarraySum extends SubarraySumTemplate {
    @Override
    public int subarraySum(int[] nums, int k) {
        // 思路
        // 1. Brute Force => 两层 for loop，时间复杂度：O(n^2)
        // 2. 数组前缀和 => 第二层 for loop，就是查找 interval[i, j] 的区间 => O(n^2)

        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (prefixSum[j + 1] - prefixSum[i] == k) {
                    result++;
                }
            }
        }

        return result;
    }
}
