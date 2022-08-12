package com.leetcode.solution.stackAndQueue.largestRectangleInHistogram.second;

import com.leetcode.solution.stackAndQueue.largestRectangleInHistogram.LargestRectangleAreaTemplate;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangleArea extends LargestRectangleAreaTemplate {
    // 思路：找到每个元素的向左延伸和向右延伸的最大值，如果比当前元素大，那么可以延伸，如果比当前元素小，那么停止延伸，此时固定了宽度 = right - left，高度为当前元素的高
    // 1. Brute Force => 两层 for loop
    // 2. 使用栈底到栈顶单调递增栈。pop 时计算面积 area = popValue * (currentIndex - stack.peekIndex - 1) O(n) + O(n)
    //                          stack 非空继续 pop => area = popValue * (length - stack.peekIndex - 1)
    // 							        栈底元素 => area = popValue * length
    // 3. 使用两次单调栈。分别确定左右两个边界，从而计算面积
    // 			       从左向右使用栈底到栈顶单调递增栈 => 确定右边界，默认值 length
    // 					从右向左使用栈底到栈顶单调递增栈 => 确定左边界，默认值 -1
    // 4. 使用一次单调栈。push 的时候就能知道 left 边界 => left = stack.isEmpty() ? -1 : stack.peek()
    @Override
    public int largestRectangleArea(int[] heights) {
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
    public int largestRectangleAreaOfTwoNextGreaterNumber(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int[] left = new int[heights.length];
        Arrays.fill(left, -1);
        int[] right = new int[heights.length];
        Arrays.fill(right, heights.length);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }

        stack.remove();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            result = Math.max(result, heights[i] * (right[i] - left[i] - 1));
        }
        return result;
    }

    @Override
    public int largestRectangleAreaWhenPop(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int result = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int index = stack.pop();
                int leftLimit = stack.isEmpty() ? -1 : stack.peek();
                result = Math.max(result, heights[index] * (i - leftLimit - 1));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            int leftLimit = stack.isEmpty() ? -1 : stack.peek();
            result = Math.max(result, heights[index] * (heights.length - leftLimit - 1));
        }

        return result;
    }


    @Override
    public int largestRectangleAreaBruteForce(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = 0;
            int right = heights.length - 1;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    left = j + 1;
                    break;
                }
            }
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] < heights[i]) {
                    right = j - 1;
                    break;
                }
            }
            result = Math.max(result, heights[i] * (right - left + 1));
        }

        return result;
    }
}
