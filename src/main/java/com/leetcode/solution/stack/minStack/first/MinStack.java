package com.leetcode.solution.stack.minStack.first;

import com.leetcode.solution.stack.minStack.MinStackTemplate;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack extends MinStackTemplate {
    // 空间复杂度：O(n)
    private final Deque<Integer> minStack;
    private final Deque<Integer> stack;

    public MinStack() {
        this.minStack = new LinkedList<>();
        this.stack = new LinkedList<>();
    }

    @Override
    public void push(int val) {
        // 时间复杂度：O(1)
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(minStack.peek(), val));
        }
        stack.push(val);
    }

    @Override
    public void pop() {
        // 时间复杂度：O(1)
        minStack.pop();
        stack.pop();
    }

    @Override
    public int top() {
        // 时间复杂度：O(1)
        return stack.peek();
    }

    @Override
    public int getMin() {
        // 时间复杂度：O(1)
        return minStack.peek();
    }
}
