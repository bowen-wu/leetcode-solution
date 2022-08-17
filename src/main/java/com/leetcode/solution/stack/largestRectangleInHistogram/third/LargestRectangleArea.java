package com.leetcode.solution.stack.largestRectangleInHistogram.third;

import com.leetcode.solution.stack.largestRectangleInHistogram.LargestRectangleAreaTemplate;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangleArea extends LargestRectangleAreaTemplate {
    @Override
    public int largestRectangleArea(int[] heights) {
        // 思路：使用栈底到栈顶单调递增栈 => 左边界右边界
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Arrays.fill(right, heights.length);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                right[stack.pop()] = i;
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }


        int result = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            result = Math.max(result, heights[i] * (right[i] - left[i] - 1));
        }

        return result;
    }

    @Override
    public int largestRectangleAreaBruteForce(int[] heights) {
        return 0;
    }

    @Override
    public int largestRectangleAreaWhenPop(int[] heights) {
        // 思路：使用栈底到栈顶单调递增栈 => pop 的时候计算面积
        // area = popValue * (currentIndex - stack.peekIndex - 1);
        // area = popValue * (currentIndex - stack.isEmpty() ? (-1) : stack.peekIndex - 1)
        // stack 中余下的值 pop => area = popValue * (length - stack.isEmpty() ? (-1) : stack.peekIndex - 1)
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int result = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int index = stack.pop();
                result = Math.max(result, heights[index] * (i - (stack.isEmpty() ? -1 : stack.peek()) - 1));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            result = Math.max(result, heights[index] * (heights.length - (stack.isEmpty() ? -1 : stack.peek()) - 1));
        }

        return result;
    }

    @Override
    public int largestRectangleAreaOfTwoNextGreaterNumber(int[] heights) {
        return 0;
    }
}
