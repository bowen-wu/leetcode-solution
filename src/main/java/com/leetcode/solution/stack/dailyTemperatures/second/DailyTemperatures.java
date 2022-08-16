package com.leetcode.solution.stack.dailyTemperatures.second;

import com.leetcode.solution.stack.dailyTemperatures.DailyTemperaturesTemplate;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures extends DailyTemperaturesTemplate {
    // 思路：
    // 1. Brute Force：双层 for loop，时间复杂度O(n^2)
    // 2. 单调栈 => 栈底到栈顶单调递减栈，当入栈比栈顶元素大时，破坏单调性，此时记录两者 index 差值即可。O(n) + O(n)
    @Override
    public int[] dailyTemperatures(int[] temperatures) {
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
