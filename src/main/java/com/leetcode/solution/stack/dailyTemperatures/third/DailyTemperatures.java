package com.leetcode.solution.stack.dailyTemperatures.third;

import com.leetcode.solution.stack.dailyTemperatures.DailyTemperaturesTemplate;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures extends DailyTemperaturesTemplate {
    @Override
    public int[] dailyTemperatures(int[] temperatures) {
        // 思路：栈底到栈顶单调递减栈
        if (temperatures == null || temperatures.length == 0) {
            return null;
        }

        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }
}
