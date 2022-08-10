package com.leetcode.solution.array.sumOddLengthSubarrays.third;

import com.leetcode.solution.array.sumOddLengthSubarrays.SumOddLengthSubarraysTemplate;

public class SumOddLengthSubarrays extends SumOddLengthSubarraysTemplate {
    @Override
    public int sumOddLengthSubarrays(int[] arr) {
        // 思路
        // 1. Brute Force => 两层 for loop，第一层是起始位置，第二层是数组长度。时间复杂度：O(n^2)
        // 2. 数组前缀和 => 第二层for loop 可是使用 interval[startIndex, startIndex + len - 1] = prefixSum[startIndex + len] - prefixSum[startIndex]，O(n^2)

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[] prefixSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        int result = prefixSum[arr.length];
        for (int startIndex = 0; startIndex < arr.length; startIndex++) {
            for (int len = 3; startIndex + len <= arr.length; len += 2) {
                result += prefixSum[startIndex + len] - prefixSum[startIndex];
            }
        }

        return result;
    }
}
