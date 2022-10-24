package com.leetcode.solution.doublePointer.twoSumLessThanK.second;

import com.leetcode.solution.doublePointer.twoSumLessThanK.TwoSumLessThanKTemplate;

import java.util.Arrays;

public class TwoSumLessThanK extends TwoSumLessThanKTemplate {
    @Override
    public int twoSumLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < k) {
                if (sum > result) {
                    result = sum;
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
