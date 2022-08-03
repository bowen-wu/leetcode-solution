package com.leetcode.solution.array.subarraySum.first;

import com.leetcode.solution.array.subarraySum.SubarraySumTemplate;

public class SubarraySum extends SubarraySumTemplate {
    @Override
    public int subarraySum(int[] nums, int k) {
        // 时间复杂度：O(n^2)
        // 空间复杂度：O(n)
        if (nums == null || nums.length == 0) {
            return 0;
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

    public int subarraySumBruteForce(int[] nums, int k) {
        // 时间复杂度：O(n^2)
        // 空间复杂度：O(1)
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result++;
                }
            }
        }

        return result;
    }
}
