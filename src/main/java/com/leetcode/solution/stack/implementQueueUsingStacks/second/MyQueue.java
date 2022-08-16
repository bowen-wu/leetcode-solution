package com.leetcode.solution.stack.implementQueueUsingStacks.second;

import com.leetcode.solution.stack.implementQueueUsingStacks.MyQueueTemplate;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue extends MyQueueTemplate {
    // 思路：使用两个栈模拟队列 => 两次 FILO == FIFO
    // push => stack1.push() => O(1)
    // pop =>
    //      stack2.isEmpty() == true => stack1 -> stack2, stack2.pop()
    //      stack2.isEmpty() == false => stack2.pop();
    // peek => stack2.isEmpty() ? stack1 栈底元素 : stack2.peek()
    // empty => stack1.isEmpty() && stack2.isEmpty()

    private final Deque<Integer> stack1;
    private final Deque<Integer> stack2;
    private Integer stack1BottomValue;

    public MyQueue() {
        this.stack1 = new LinkedList<>();
        this.stack2 = new LinkedList<>();
        this.stack1BottomValue = null;
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
        // 时间复杂度：O(1)
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
        return stack2.isEmpty() ? stack1BottomValue : stack2.peek();
    }

    @Override
    public boolean empty() {
        // 时间复杂度：O(1)
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
