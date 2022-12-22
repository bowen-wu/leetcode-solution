package com.leetcode.solution.doublePointer.containerWithMostWater.fourth;

import com.leetcode.solution.doublePointer.containerWithMostWater.MaxAreaTemplate;

public class MaxArea extends MaxAreaTemplate {
    @Override
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            int currentHeight = 0;
            if (height[left] < height[right]) {
                currentHeight = height[left];
                left++;
            } else {
                currentHeight = height[right];
                right--;
            }

            result = Math.max(result, width * currentHeight);
        }

        return result;
    }
}
