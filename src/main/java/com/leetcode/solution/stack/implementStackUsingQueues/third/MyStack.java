package com.leetcode.solution.stack.implementStackUsingQueues.third;

import com.leetcode.solution.stack.implementStackUsingQueues.MyStackTemplate;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack extends MyStackTemplate {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    @Override
    public void push(int x) {
        // 思路：push 到 q2 中，之后把 q1 的全都放入 q2 中，之后交换 O(n)
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    @Override
    public int pop() {
        // O(1)
        return queue1.poll();
    }

    @Override
    public int top() {
        // O(1)
        return queue1.peek();
    }

    @Override
    public boolean empty() {
        return queue1.isEmpty();
    }
}
