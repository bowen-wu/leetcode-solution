package com.leetcode.solution.doublePointer.twoSumLessThanK.third;

import com.leetcode.solution.doublePointer.twoSumLessThanK.TwoSumLessThanKTemplate;

import java.util.Arrays;

public class TwoSumLessThanK extends TwoSumLessThanKTemplate {
    @Override
    public int twoSumLessThanK(int[] nums, int k) {
        // check input
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int result = Integer.MIN_VALUE;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < k) {
                if (sum > result) {
                    // update
                    result = sum;
                }
                start++;
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
            } else {
                end--;
                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            }
        }
        return result == Integer.MIN_VALUE ? -1 : result;
    }
}
