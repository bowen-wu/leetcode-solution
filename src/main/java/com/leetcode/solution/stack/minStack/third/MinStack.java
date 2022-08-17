package com.leetcode.solution.stack.minStack.third;

import com.leetcode.solution.stack.minStack.MinStackTemplate;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack extends MinStackTemplate {
    // 思路：O(1) 获取到栈内最小值，需要记录最小值历史 => 使用一个栈记录
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    @Override
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(minStack.peek(), x));
        }
    }

    @Override
    public void pop() {
        minStack.pop();
        stack.pop();
    }

    @Override
    public int top() {
        return stack.peek();
    }

    @Override
    public int getMin() {
        return minStack.peek();
    }
}
