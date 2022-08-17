package com.leetcode.solution.stack.nextGreaterElementII.third;

import com.leetcode.solution.stack.nextGreaterElementII.NextGreaterElementsTemplate;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElements extends NextGreaterElementsTemplate {
    @Override
    public int[] nextGreaterElements(int[] nums) {
        // 思路：使用栈底到栈顶单调递减栈。循环数组，拼接两个数组
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length * 2; i++) {
            int index = i % nums.length;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                result[stack.pop()] = nums[index];
            }
            stack.push(index);
        }

        return result;
    }
}
