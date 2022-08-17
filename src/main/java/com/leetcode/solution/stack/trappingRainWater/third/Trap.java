package com.leetcode.solution.stack.trappingRainWater.third;

import com.leetcode.solution.stack.trappingRainWater.TrapTemplate;

import java.util.ArrayDeque;
import java.util.Deque;

public class Trap extends TrapTemplate {
    @Override
    public int trap(int[] height) {
        // 思路：栈底到栈顶单调递减栈。pop 的时候计算面积，右边界当前值，左边界 stack.peek()
        // => area = (Math.min(currentValue, stack.peekValue) - popValue) * (currentIndex - stack.peekIndex - 1)
        // 相等不 pop
        if (height == null || height.length == 0) {
            return 0;
        }

        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int popIndex = stack.pop();
                if (!stack.isEmpty()) {
                    result += (Math.min(height[i], height[stack.peek()]) - height[popIndex]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }

        return result;
    }
}
