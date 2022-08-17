## 用栈实现队列

<https://leetcode.cn/problems/implement-queue-using-stacks/>

### 思路

使用两个栈模拟队列

- offer => stack1.push
- isEmpty => stack1.isEmpty() && stack2.isEmpty()
- poll
    1. stack2 isEmpty => stack1 -> stack2, stack2.pop()
    2. stack2 noEmpty => stack2.pop()
- peek
    1. stack2 isEmpty => stack1 -> stack2, stack2.peek()
    2. stack2 noEmpty => stack2.peek()

#### 优化

优化 peek 最坏时间复杂度 => 添加 stack1BottomValue 变量

- peek
    1. stack1 isEmpty => 记录 stack1BottomValue
    2. stack2 isEmpty => 返回 stack1BottomValue
    3. stack2 noEmpty => 返回 stack2.peek()

### pop 时间复杂度分析

- 最好时间复杂度 => O(1)
- 最坏时间复杂度 => O(n)

平均时间复杂度分析：对于每一个元素，最多有四个操作

1. s1入栈
2. s1出栈
3. s2入栈
4. s2出栈

故对于每一个元素，**平均时间复杂度是 O(1)**

### 总结

| 问题行数   | 错误点            | 正确写法                   | 错误原因    |
|--------|----------------|------------------------|---------|
| 25, 32 | 使用 add API     | 使用 push API            | API 不熟  |
| 43     | public empty() | public boolean empty() | 签名写错，大意 |

```java
class MyQueue {
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

    public void push(int x) {
        // 时间复杂度：O(1)
        if (stack1.isEmpty()) {
            stack1BottomValue = x;
        }
        stack1.push(x);
    }

    public int pop() {
        // 时间复杂度：O(1)
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        // 时间复杂度：O(1)
        return stack2.isEmpty() ? stack1BottomValue : stack2.peek();
    }

    public boolean empty() {
        // 时间复杂度：O(1)
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
```
