package com.leetcode.solution.doublePointer.validTriangleNumber.third;

import com.leetcode.solution.doublePointer.validTriangleNumber.TriangleNumberTemplate;

import java.util.Arrays;

public class TriangleNumber extends TriangleNumberTemplate {
    @Override
    public int triangleNumber(int[] nums) {
        // a + b > c
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int len = nums.length;
        int result = 0;
        for (int i = len - 1; i >= 2; i--) {
            int start = 0;
            int end = i - 1;
            while (start < end) {
                if (nums[start] + nums[end] > nums[i]) {
                    result += end - start;
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }
}
