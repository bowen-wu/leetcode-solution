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
  
