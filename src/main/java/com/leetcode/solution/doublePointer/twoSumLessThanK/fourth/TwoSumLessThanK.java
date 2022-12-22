package com.leetcode.solution.doublePointer.twoSumLessThanK.fourth;

import com.leetcode.solution.doublePointer.twoSumLessThanK.TwoSumLessThanKTemplate;

import java.util.Arrays;

public class TwoSumLessThanK extends TwoSumLessThanKTemplate {
    @Override
    public int twoSumLessThanK(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return -1;
        }

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                result = Math.max(result, sum);
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
