package com.leetcode.solution.doublePointer.twoSumII.first;

import com.leetcode.solution.doublePointer.twoSumII.TwoSumTemplate;

public class TwoSum extends TwoSumTemplate {
    @Override
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }

        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            }
            if (numbers[start] + numbers[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[0];
    }
}
