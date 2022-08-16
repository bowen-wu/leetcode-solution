package com.leetcode.solution.stack.nextGreaterNumber.first;

import com.leetcode.solution.stack.nextGreaterNumber.NextGreaterNumberTemplate;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterNumber extends NextGreaterNumberTemplate {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterNumber().findRightNextGreater(new int[]{1, 5, 3, 6, 4, 8, 9, 10}))); // 5, 6, 6, 8, 8, 9, 10, -1
        System.out.println(Arrays.toString(new NextGreaterNumber().findLeftNextGreater(new int[]{1, 5, 3, 6, 4, 8, 9, 10}))); // -1, -1, 5, -1, 6, -1, -1, -1
        System.out.println(Arrays.toString(new NextGreaterNumber().findRightNextSmaller(new int[]{1, 5, 3, 6, 4, 8, 9, 10}))); // -1, 3, -1, 4, -1, -1, -1, -1
        System.out.println(Arrays.toString(new NextGreaterNumber().findLeftNextSmaller(new int[]{1, 5, 3, 6, 4, 8, 9, 10}))); // -1, 1, 1, 3, 3, 4, 8, 9
    }

    @Override
    public int[] findRightNextGreater(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // Greater => 栈底到栈顶单调递减 =>
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                Integer index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }

    @Override
    public int[] findLeftNextGreater(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        Deque<Integer> stack = new LinkedList<>();

        // 左侧 => 从右向左
        for (int i = nums.length - 1; i >= 0; i--) {
            // Greater => 栈底到栈顶单调递减
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }

    @Override
    public int[] findRightNextSmaller(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new LinkedList<>();

        // 右侧 => 从左向右
        for (int i = 0; i < nums.length; i++) {
            // Smaller => 从栈底到栈顶单调递增
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        return result;
    }

    @Override
    public int[] findLeftNextSmaller(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new LinkedList<>();

        // Left => 从右向左
        for (int i = nums.length - 1; i >= 0; i--) {
            // Smaller => 栈底到栈顶单调递增
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }
}
