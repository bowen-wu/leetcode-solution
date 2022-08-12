package com.leetcode.solution.stackAndQueue.nextGreaterElementII.second;

import com.leetcode.solution.stackAndQueue.nextGreaterElementII.NextGreaterElementsTemplate;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElements extends NextGreaterElementsTemplate {
    // 思路：使用栈底到栈顶单调递减栈，得到除了最后一个的更大的数，最后一个再 for loop 一次数组。O(n) + O(n)
    // 优化，开始遍历前，记录最后一个数，之后在做单调递减栈的时候，就找比最后一个大的数即可
    // case: 1432. 不能满足
    // 循环需要拼接两个数组 14321432。做栈底到栈顶的单调递减栈。取前n项作为结果返回
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                result[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }

        return result;
    }
}
