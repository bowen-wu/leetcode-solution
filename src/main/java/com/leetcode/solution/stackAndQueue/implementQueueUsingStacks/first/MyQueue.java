package com.leetcode.solution.stackAndQueue.implementQueueUsingStacks.first;

import com.leetcode.solution.stackAndQueue.implementQueueUsingStacks.MyQueueTemplate;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 思路：
 * 使用两个栈模拟队列
 * offer => stack1.push
 * isEmpty => stack1.isEmpty() && stack2.isEmpty()
 * poll
 * 1. stack2 isEmpty => stack1 -> stack2, stack2.pop()
 * 2. stack2 noEmpty => stack2.pop()
 * peek
 * 1. stack2 isEmpty => stack1 -> stack2, stack2.peek()
 * 2. stack2 noEmpty => stack2.peek()
 * <p>
 * 优化：优化 peek 最坏时间复杂度 => 添加 stack1BottomValue 变量
 * <p>
 * peek
 * 1. stack1 isEmpty => 记录 stack1BottomValue
 * 2. stack2 isEmpty => 返回 stack1BottomValue
 * 3. stack2 noEmpty => 返回 stack2.peek()
 */
public class MyQueue extends MyQueueTemplate {
    // 空间复杂度：O(n)
    private final Deque<Integer> stack1;
    private final Deque<Integer> stack2;
    private Integer stack1BottomValue;

    public MyQueue() {
        this.stack1 = new ArrayDeque<>();
        this.stack2 = new ArrayDeque<>();
    }

    @Override
    public void push(int x) {
        // 时间复杂度：O(1)
        if (stack1.isEmpty()) {
            stack1BottomValue = x;
        }
        stack1.push(x);
    }

    @Override
    public int pop() {
        // 时间复杂度：O(1) => 可见 README.md 时间复杂度分析
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    @Override
    public int peek() {
        // 时间复杂度：O(1)
        if (stack2.isEmpty()) {
            return stack1BottomValue;
        }
        return stack2.peek();
    }


    @Override
    public boolean empty() {
        // 时间复杂度：O(1)
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
