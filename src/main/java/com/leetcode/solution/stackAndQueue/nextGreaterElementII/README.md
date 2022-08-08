## 下一个更大元素 II

<https://leetcode.cn/problems/next-greater-element-ii/>

### 思路

单调栈

- **右侧** => 从左向右
- **Greater** => 栈底到栈顶单调递减

1. 拼接两个数组，之后使用单调栈找到最大值
2. 取前n个作为结果返回

#### 优化

1. 拼接两个数组，下标可以对 length 取模 => i % nums.length

### 总结
