# 栈

## 概述

- 栈 => LIFO => 后进先出
- 队列 => FIFO => 先进先出

## Stack

### 初始化

```
Deque<Integer> stack=new ArrayDeque<>();
Deque<Integer> stack = new LinkedList<>();
```

### 基本操作

| 方法      | 参数      | 返回值          | 时间复杂度  |
|---------|---------|--------------|--------|
| push    | Element | Element/void | O(1)   |
| pop     | void    | Element      | O(1)   |
| peek    | void    | Element      | O(1)   |
| isEmpty | void    | boolean      | O(1)   |

### 使用场景

1. 递归
2. 深度优先搜索 DFS(Depth-first Search)
3. 单调栈


### 单调栈

- Monotone Stack
- 在栈的先进后出基础上额外增加一个特性：从栈底到栈顶的元素是严格递增或严格递减

#### 单调递减栈 - 从栈底到栈顶递减

- 只有比栈顶元素**小**的元素才能直接入栈，否则需要先将栈中比当前元素**小**的元素都出栈，再将当前元素入栈
- 保证栈中保留的都是比当前入栈元素**大**的值
- 从**栈底**到**栈顶**的元素值是单调递减的

```
Deque<Integer> stack = new ArraysDeque<>();
for (int i = 0; i < nums.lenght; i++) {
    while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
        stack.pop(); 
    }
    stack.push(i);
}
```

#### 单调递增栈 - 从栈底到栈顶递增

- 只有比栈顶元素**大**的元素才能直接入栈，否则需要先将栈中比当前元素**大**的元素都出栈，再将当前元素入栈
- 保证栈中保留的都是比当前入栈元素**小**的值
- 从**栈底**到**栈顶**的元素值是单调递增的

```
Deque<Integer> stack = new ArraysDeque<>();
for (int i = 0; i < nums.length; i++) {
    while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
        stack.pop(); 
    }
    stack.push(i);
}
```

#### Next Great Number 问题总结

1. 求数组中**右侧**第一个比它**大**的值
2. 求数组中**右侧**第一个比它**小**的值
3. 求数组中**左侧**第一个比它**大**的值
4. 求数组中**左侧**第一个比它**小**的值

- **右侧** => 从左向右遍历
- **左侧** => 从右向左遍历
- **大** => 单调递减 => 默认都是 -1，找到破坏单调性的值
- **小** => 单调递增 => 默认都是 -1，找到破坏单调性的值

### Stack vs Heap

#### 栈

- 存储 primitive variables function call
- stack 读取速度更快

#### 堆

- 存放引用类型变量
- 可以动态分配内存空间

