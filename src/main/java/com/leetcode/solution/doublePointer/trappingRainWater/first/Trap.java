package com.leetcode.solution.doublePointer.trappingRainWater.first;

import com.leetcode.solution.doublePointer.trappingRainWater.TrapTemplate;

import java.util.ArrayDeque;
import java.util.Deque;

public class Trap extends TrapTemplate {
    @Override
    public int trapWithTraversal(int[] height) {
        // Ideas: traversal get left | right limit
        // check input
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] heights = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            // 从左到右获取每个位置上的左边界
            max = Math.max(max, height[i]);
            heights[i] = max;
        }

        int result = 0;
        max = Integer.MIN_VALUE;
        for (int i = height.length - 1; i >= 0; i--) {
            // max => 从右到左每个位置上的右边界
            max = Math.max(max, height[i]);
            result += Math.min(heights[i], max) - height[i];
        }
        return result;
    }

    @Override
    public int trapWithDoublePointer(int[] height) {
        // Ideas: Double pointer => 短板移动
        // check input
        if (height == null || height.length == 0) {
            return 0;
        }

        int result = 0;
        int start = 0;
        int end = height.length - 1;
        int leftMax = height[start];
        int rightMax = height[end];
        while (start < end) {
            if (height[start] < height[end]) {
                result += Math.min(leftMax, rightMax) - height[start];
                start++;
                leftMax = Math.max(leftMax, height[start]);
            } else {
                result += Math.min(leftMax, rightMax) - height[end];
                end--;
                rightMax = Math.max(rightMax, height[end]);
            }
        }

        return result;
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int result = 0;
        int start = 0;
        int end = height.length - 1;
        int leftMax = height[start];
        int rightMax = height[end];
        while (start <= end) {
            if (leftMax < rightMax) {
                leftMax = Math.max(leftMax, height[start]);
                result += leftMax - height[start];
                start++;
            } else {
                rightMax = Math.max(rightMax, height[end]);
                result += rightMax - height[end];
                end--;
            }
        }

        return result;
    }

    @Override
    public int trapWithMonotonicStack(int[] height) {
        // Ideas: 单调栈 => 栈底到栈顶单调递减栈
        if (height == null || height.length == 0) {
            return 0;
        }

        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int index = stack.pop();
                if (!stack.isEmpty()) {
                    result += (Math.min(height[stack.peek()], height[i]) - height[index]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }

        return result;
    }
}
