package com.leetcode.solution.doublePointer.threeSumSmaller.second;

import com.leetcode.solution.doublePointer.threeSumSmaller.ThreeSumSmallerTemplate;

import java.util.Arrays;

public class ThreeSumSmaller extends ThreeSumSmallerTemplate {
    @Override
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int length = nums.length;
        int result = 0;
        for (int i = length - 1; i > 1; i--) {
            int start = 0;
            int end = i - 1;
            while (start < end) {
                if (nums[start] + nums[end] + nums[i] < target) {
                    result += end - start;
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}
