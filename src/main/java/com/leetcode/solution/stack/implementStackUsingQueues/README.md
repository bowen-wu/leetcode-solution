## 用队列实现栈

<https://leetcode.cn/problems/implement-stack-using-queues/>

### 思路

两个队列 q1 和 q2

- push
    1. q1 和 q2 如果都是空，q1.offer
    2. q1 empty => q2.offer
    3. q2 empty => q1.offer
- pop
    1. q2 empty => q1 -> q2，when q1.size == 1，q1.poll()
    2. q1 empty => q2 -> q1，when q2.size == 1，q2.poll()
- peek
    1. q2 empty => q1 -> q2，when q1.size == 1，q1.poll()
    2. q1 empty => q2 -> q1，when q2.size == 1，q2.poll()
- isEmpty => q1.isEmpty() && q2.isEmpty()

#### 答案

- push => q2.offer()，q1 -> q2，q1 = q2
- pop => q1.poll()
- peek => q1.peek()

### 总结

| 问题行数 | 错误点                          | 正确写法          | 错误原因                             |
|------|------------------------------|---------------|----------------------------------|
| 11   | pulic                        | public        | 笔误                               |
| 17   | queue2.push(x)               | queue2.add(x) | API 掌握不够                         |
| 8, 9 | private final Queue<Integer> | -             | 不应该定义成 final 的，因为第22行有赋值操作，改变了指针 |


```java
class MyStack {
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

    public void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
```
