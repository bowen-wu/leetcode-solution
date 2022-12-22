package com.leetcode.solution.doublePointer.trappingRainWater.third;

import com.leetcode.solution.doublePointer.trappingRainWater.TrapTemplate;

public class Trap extends TrapTemplate {
    @Override
    public int trapWithTraversal(int[] height) {
        return 0;
    }

    @Override
    public int trapWithDoublePointer(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftLimit = height[left];
        int rightLimit = height[right];
        int result = 0;

        while (left < right) {
            int limit = Math.min(leftLimit, rightLimit);
            if (height[left] < height[right]) {
                if (limit > height[left]) {
                    result += (limit - height[left]);
                }
                left++;
                leftLimit = Math.max(leftLimit, height[left]);
            } else {
                if (limit > height[right]) {
                    result += (limit - height[right]);
                }
                right--;
                rightLimit = Math.max(rightLimit, height[right]);
            }
        }

        return result;
    }

    @Override
    public int trapWithMonotonicStack(int[] height) {
        return 0;
    }
}
