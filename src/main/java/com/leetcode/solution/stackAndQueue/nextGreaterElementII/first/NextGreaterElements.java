package com.leetcode.solution.stackAndQueue.nextGreaterElementII.first;

import com.leetcode.solution.stackAndQueue.nextGreaterElementII.NextGreaterElementsTemplate;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElements extends NextGreaterElementsTemplate {
    @Override
    public int[] nextGreaterElements(int[] nums) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length * 2; i++) {
            int index = i % nums.length;

            // Greater => 栈底到栈顶单调递减
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                result[stack.pop()] = nums[index];
            }
            stack.push(index);
        }

        return result;
    }
}
