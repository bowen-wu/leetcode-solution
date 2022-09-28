package com.leetcode.solution.doublePointer.threeSumSmaller.first;

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
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum < target) {
                    result += end - start;

                    // 有可能破坏上述条件
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }

    public int threeSumSmallerFromEnd(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int start = 0;
            int end = i - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum < target) {
                    result += end - start;

                    // 有可能破坏上述条件
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}
