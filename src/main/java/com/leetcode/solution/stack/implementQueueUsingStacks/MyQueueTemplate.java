package com.leetcode.solution.stack.implementQueueUsingStacks;

/**
 * https://leetcode.cn/problems/implement-queue-using-stacks/
 * 232. 用栈实现队列
 * <p>
 * 使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 注意: 你只能使用标准的栈操作。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 */
abstract public class MyQueueTemplate {
    abstract public void push(int x);

    abstract public int pop();

    abstract public int peek();

    abstract public boolean empty();
}
