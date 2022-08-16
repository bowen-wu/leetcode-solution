## 最小栈

<https://leetcode.cn/problems/min-stack/>

### 思路

记录历史数据，使用栈记录历史最小值。stack & minStack

- push
    - stack => push
    - minStack => 比较一下，之后 push min value
- pop => stack + minStack 都 pop
- peek => stack.peek()
- getMin => minStack.peek()

#### 优化

使用 Math.min 优化最小值判断

### 总结

```java
class MinStack {
    // 思路：如何在常数时间内检索到最小值，并且是记录 history
    // 最小值 pop 之后需要更新，所以是记录 history
    // 使用辅助栈进行记录最小值

    private final Deque<Integer> minStack;
    private final Deque<Integer> stack;

    public MinStack() {
        this.minStack = new LinkedList<>();
        this.stack = new LinkedList<>();
    }

    public void push(int val) {
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(minStack.peek(), val));
        }
        stack.push(val);
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
```

| 问题行数       | 错误点        | 正确写法        | 错误原因   |
|------------|------------|-------------|--------|
| 16, 18, 20 | 使用 add API | 使用 push API | API 不熟 |
