package com.leetcode.solution.doublePointer.containerWithMostWater.first;

import com.leetcode.solution.doublePointer.containerWithMostWater.MaxAreaTemplate;

public class MaxArea extends MaxAreaTemplate {
    @Override
    public int maxArea(int[] height) {
        // Ideas: 双指针 => 比较两个指针的高度，移动高度小的
        // 时间复杂度：O(n)
        if (height == null || height.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            if (height[start] < height[end]) {
                result = Math.max(height[start] * (end - start), result);
                start++;
            } else {
                result = Math.max(height[end] * (end - start), result);
                end--;
            }
        }

        return result;
    }

    public int maxAreaWhile(int[] height) {
        // Ideas: 双指针 => 比较两个指针的高度，移动高度小的
        // 时间复杂度：O(n)
        if (height == null || height.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            int currentHeight = Math.min(height[start], height[end]);
            result = Math.max(currentHeight * (end - start), result);
            if (height[start] < height[end]) {
                start++;
                while (start < end && height[start] < currentHeight) {
                    start++;
                }
            } else {
                end--;
                while (start < end && height[end] < currentHeight) {
                    end--;
                }
            }
        }

        return result;
    }
}
