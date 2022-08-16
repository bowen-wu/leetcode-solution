package com.leetcode.solution.stack.largestRectangleInHistogram.first;

import com.leetcode.solution.stack.largestRectangleInHistogram.LargestRectangleAreaTemplate;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleArea extends LargestRectangleAreaTemplate {
    @Override
    public int largestRectangleAreaOfTwoNextGreaterNumber(int[] heights) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Deque<Integer> stack = new LinkedList<>();

        int[] rightWidth = new int[heights.length];
        Arrays.fill(rightWidth, heights.length);
        for (int i = 0; i < heights.length; i++) {
            // Smaller => 栈底到栈顶单调递增
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                rightWidth[stack.pop()] = i;
            }
            stack.push(i);
        }

        stack.clear();
        int[] leftWidth = new int[heights.length];
        Arrays.fill(leftWidth, -1);
        for (int i = heights.length - 1; i >= 0; i--) {
            // Smaller => 栈底到栈顶单调递增
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                leftWidth[stack.pop()] = i;
            }
            stack.push(i);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int currentArea = heights[i] * (rightWidth[i] - leftWidth[i] - 1);
            result = Math.max(result, currentArea);
        }

        return result;
    }

    @Override
    public int largestRectangleAreaBruteForce(int[] heights) {
        // 时间复杂度：O(n^2)
        // 空间复杂度：O(1)
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int result = heights[0];
        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];
            int currentResult = heights[i];
            for (int j = i + 1; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                currentResult = Math.max(currentResult, minHeight * (j - i + 1));
            }
            result = Math.max(currentResult, result);
        }

        return result;
    }

    @Override
    public int largestRectangleAreaWhenPop(int[] heights) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        int result = Integer.MIN_VALUE;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            // Smaller => 栈底到栈顶单调递增
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                result = Math.max(result, getCurrentArea(stack, heights[stack.pop()], i));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result = Math.max(result, getCurrentArea(stack, heights[stack.pop()], heights.length));
        }

        return result;
    }

    private int getCurrentArea(Deque<Integer> stack, int height, int right) {
        // currentArea = popValue * (right - 栈顶元素Index - 1)
        int left = stack.isEmpty() ? -1 : stack.peek();
        return height * (right - left - 1);
    }

    @Override
    public int largestRectangleArea(int[] heights) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Deque<Integer> stack = new LinkedList<>();

        int[] leftWidth = new int[heights.length];
        int[] rightWidth = new int[heights.length];
        Arrays.fill(rightWidth, heights.length);
        for (int i = 0; i < heights.length; i++) {
            // Smaller => 栈底到栈顶单调递增
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                rightWidth[stack.pop()] = i;
            }

            leftWidth[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int currentArea = heights[i] * (rightWidth[i] - leftWidth[i] - 1);
            result = Math.max(result, currentArea);
        }

        return result;
    }
}
