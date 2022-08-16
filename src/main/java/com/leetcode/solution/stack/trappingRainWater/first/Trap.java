package com.leetcode.solution.stack.trappingRainWater.first;

import com.leetcode.solution.stack.trappingRainWater.TrapTemplate;

import java.util.Deque;
import java.util.LinkedList;

public class Trap extends TrapTemplate {
    @Override
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int result = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            // 栈底到栈顶单调递减
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                Integer index = stack.pop();
                if (!stack.isEmpty()) {
                    // area = (Math.min(currentValue, stack.peekValue) - popValue) * (currentIndex - stack.peekIndex - 1)
                    result += (Math.min(height[i], height[stack.peek()]) - height[index]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return result;
    }
}
