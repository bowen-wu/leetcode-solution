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
