package com.leetcode.solution.stack.minStack.second;

import com.leetcode.solution.stack.minStack.MinStackTemplate;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack extends MinStackTemplate {
    // 思路：如何在常数时间内检索到最小值，并且是记录 history
    // 最小值 pop 之后需要更新，所以是记录 history
    // 使用辅助栈进行记录最小值

    private final Deque<Integer> minStack;
    private final Deque<Integer> stack;

    public MinStack() {
        this.minStack = new LinkedList<>();
        this.stack = new LinkedList<>();
    }

    @Override
    public void push(int val) {
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(minStack.peek(), val));
        }
        stack.push(val);
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
