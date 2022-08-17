package com.leetcode.solution.stack.implementQueueUsingStacks.third;

import com.leetcode.solution.stack.implementQueueUsingStacks.MyQueueTemplate;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue extends MyQueueTemplate {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;
    private int stack1BottomValue;

    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    @Override
    public void push(int x) {
        if (stack1.isEmpty()) {
            stack1BottomValue = x;
        }
        stack1.push(x);
    }

    @Override
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    @Override
    public int peek() {
        if (stack2.isEmpty()) {
            return stack1BottomValue;
        }
        return stack2.peek();
    }

    @Override
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
