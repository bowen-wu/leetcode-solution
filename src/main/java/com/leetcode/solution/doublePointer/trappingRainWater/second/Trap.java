package com.leetcode.solution.doublePointer.trappingRainWater.second;

import com.leetcode.solution.doublePointer.trappingRainWater.TrapTemplate;

import java.util.ArrayDeque;
import java.util.Deque;

public class Trap extends TrapTemplate {
    @Override
    public int trapWithTraversal(int[] height) {
        // check input
        if (height == null || height.length == 0) {
            return 0;
        }

        int len = height.length;
        int[] leftLimit = new int[height.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, height[i]);
            leftLimit[i] = max;
        }

        max = Integer.MIN_VALUE;
        int result = 0;
        for (int i = len - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            result += Math.min(leftLimit[i], max) - height[i];
        }

        return result;
    }

    @Override
    public int trapWithDoublePointer(int[] height) {
        // check input
        if (height == null || height.length == 0) {
            return 0;
        }

        int start = 0;
        int end = height.length - 1;
        int leftMax = height[start];
        int rightMax = height[end];
        int result = 0;
        while (start <= end) {
            // 移动小的 max => area = (min(leftMax, rightMax) - height[i]) * 1
            if (leftMax < rightMax) {
                leftMax = Math.max(leftMax, height[start]);
                result += leftMax - height[start];
                start++;
            } else {
                // leftMax > rightMax
                rightMax = Math.max(rightMax, height[end]);
                result += rightMax - height[end];
                end--;
            }
        }

        return result;
    }

    @Override
    public int trapWithMonotonicStack(int[] height) {
        // check input
        if (height == null || height.length == 0) {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int index = stack.pop();
                if (!stack.isEmpty()) {
                    int area = (Math.min(height[i], height[stack.peek()]) - height[index]) * (i - stack.peek() - 1);
                    result += area;
                }
            }
            stack.push(i);
        }
        return result;
    }
}
