package com.leetcode.solution.doublePointer.threeSumSmaller.fourth;

import com.leetcode.solution.doublePointer.threeSumSmaller.ThreeSumSmallerTemplate;

import java.util.Arrays;

public class ThreeSumSmaller extends ThreeSumSmallerTemplate {
    @Override
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int result = 0;
        int len = nums.length;
        for (int i = len - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum < target) {
                    result += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
