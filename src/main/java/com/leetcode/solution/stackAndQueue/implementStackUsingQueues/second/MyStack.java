package com.leetcode.solution.stackAndQueue.implementStackUsingQueues.second;

import com.leetcode.solution.stackAndQueue.implementStackUsingQueues.MyStackTemplate;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack extends MyStackTemplate {
    // 思路：使用两个队列实现栈
    // push => q2.add()，之后将 q1 所有的元素添加到 q2 中，之后再将 q1 和 q2 互换。O(n)
    // pop => q1.poll()
    // top => q1.peek()
    // empty => q1.isEmpty()

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    @Override
    public void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    @Override
    public int pop() {
        return queue1.poll();
    }

    @Override
    public int top() {
        return queue1.peek();
    }

    @Override
    public boolean empty() {
        return queue1.isEmpty();
    }
}
