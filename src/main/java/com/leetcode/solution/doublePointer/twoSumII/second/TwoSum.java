package com.leetcode.solution.doublePointer.twoSumII.second;

import com.leetcode.solution.doublePointer.twoSumII.TwoSumTemplate;

public class TwoSum extends TwoSumTemplate {
    @Override
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[2];
        }

        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                return new int[]{start + 1, end + 1};
            }
            if (sum > target) {
                end--;
            } else {
                start++;
            }
        }

        return new int[2];
    }
}
