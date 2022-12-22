package com.leetcode.solution.doublePointer.validTriangleNumber.fourth;

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
        int len = nums.length;
        for (int i = len - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    result += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
