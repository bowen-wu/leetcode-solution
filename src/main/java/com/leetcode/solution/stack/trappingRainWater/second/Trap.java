package com.leetcode.solution.stack.trappingRainWater.second;

import com.leetcode.solution.stack.trappingRainWater.TrapTemplate;

import java.util.ArrayDeque;
import java.util.Deque;

public class Trap extends TrapTemplate {
    // 思路：使用栈底到栈顶单调递减栈。pop 的时候计算当前储水量
    // 		area = height * width = (Math.min(leftLimit, rightLimit) - currentHeight) * (rightLimitIndex - leftLimitIndex)
    //      area = (Math.min(stack.peekValue, currentValue) - popValue) * (currentIndex - stack.peekIndex - 1) => stack 非空
    @Override
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return -1;
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
