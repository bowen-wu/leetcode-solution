package com.leetcode.solution.doublePointer.containerWithMostWater.second;

import com.leetcode.solution.doublePointer.containerWithMostWater.MaxAreaTemplate;

public class MaxArea extends MaxAreaTemplate {
    @Override
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int result = Integer.MIN_VALUE;
        while (left < right) {
            int area = 0;
            int currentHeight = 0;
            if (height[left] > height[right]) {
                currentHeight = height[right];
                area = (right - left) * currentHeight;
                right--;
                while (left < right && height[right] < currentHeight) {
                    right--;
                }
            } else {
                currentHeight = height[left];
                area = (right - left) * currentHeight;
                left++;
                while (left < right && height[left] < currentHeight) {
                    left++;
                }
            }
            result = Math.max(area, result);
        }
        return result;
    }
}
