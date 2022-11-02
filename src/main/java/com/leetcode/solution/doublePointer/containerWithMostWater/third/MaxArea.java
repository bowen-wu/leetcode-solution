package com.leetcode.solution.doublePointer.containerWithMostWater.third;

import com.leetcode.solution.doublePointer.containerWithMostWater.MaxAreaTemplate;

public class MaxArea extends MaxAreaTemplate {
    @Override
    public int maxArea(int[] height) {
        // check input
        if (height == null || height.length == 0) {
            return 0;
        }

        int len = height.length;
        int start = 0;
        int end = len - 1;
        int result = 0;
        while (start < end) {
            int startHeight = height[start];
            int endHeight = height[end];
            int area;
            if (startHeight < endHeight) {
                area = startHeight * (end - start);
                start++;
                while (start < end && height[start] <= startHeight) {
                    start++;
                }
            } else {
                area = endHeight * (end - start);
                end--;
                while (start < end && height[end] <= endHeight) {
                    end--;
                }
            }

            result = Math.max(result, area);
        }
        return result;
    }
}
