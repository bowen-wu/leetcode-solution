## 用栈实现队列

<https://leetcode.cn/problems/implement-queue-using-stacks/>

### 思路

思路：使用两个栈模拟队列

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
