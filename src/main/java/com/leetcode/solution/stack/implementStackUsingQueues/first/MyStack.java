package com.leetcode.solution.stack.implementStackUsingQueues.first;

import com.leetcode.solution.stack.implementStackUsingQueues.MyStackTemplate;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack extends MyStackTemplate {
    private Deque<Integer> queue1;
    private Deque<Integer> queue2;

    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    @Override
    public void push(int x) {
        // 时间复杂度：O(1)
        queue2.push(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.pop());
        }
        Deque<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    @Override
    public int pop() {
        // 时间复杂度：O(1)
        return queue1.poll();
    }

    @Override
    public int top() {
        // 时间复杂度：O(1)
        return queue1.peek();
    }

    @Override
    public boolean empty() {
        // 时间复杂度：O(1)
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
