package com.leetcode.solution.doublePointer.twoSumLessThanK.first;

import com.leetcode.solution.doublePointer.twoSumLessThanK.TwoSumLessThanKTemplate;

import java.util.Arrays;

public class TwoSumLessThanK extends TwoSumLessThanKTemplate {
    @Override
    public int twoSumLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int result = Integer.MIN_VALUE;
        if (nums[start] > k) {
            return -1;
        }
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum > result && sum < k) {
                result = sum;
            }
            if (sum < k) {
                start++;
            } else {
                end--;
            }
        }
        return result == Integer.MIN_VALUE ? -1 : result;
    }
}
