package com.leetcode.solution.doublePointer.validTriangleNumber.second;

import com.leetcode.solution.doublePointer.validTriangleNumber.TriangleNumberTemplate;

import java.util.Arrays;

public class TriangleNumber extends TriangleNumberTemplate {
    @Override
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int result = 0;
        for (int i = nums.length - 1; i > 1; i--) {
            int end = i - 1;
            int start = 0;
            while (start < end) {
                if (nums[start] + nums[end] <= nums[i]) {
                    start++;
                } else {
                    result += end - start;
                    end--;
                }
            }
        }

        return result;
    }
}
