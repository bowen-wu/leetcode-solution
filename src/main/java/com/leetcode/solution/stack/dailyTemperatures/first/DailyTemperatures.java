package com.leetcode.solution.stack.dailyTemperatures.first;

import com.leetcode.solution.stack.dailyTemperatures.DailyTemperaturesTemplate;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures extends DailyTemperaturesTemplate {
    @Override
    public int[] dailyTemperatures(int[] temperatures) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        if (temperatures == null || temperatures.length == 0) {
            return null;
        }

        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();

        // 右侧 => 从左向右
        for (int i = 0; i < temperatures.length; i++) {
            // Greater => 栈底到栈顶单调递减
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
