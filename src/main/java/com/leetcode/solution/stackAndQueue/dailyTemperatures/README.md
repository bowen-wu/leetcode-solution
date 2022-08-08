## 每日温度

<https://leetcode.cn/problems/daily-temperatures/>

### 思路

使用单调栈

- **右侧** => 从左向右遍历
- **Greater** => 栈底到栈顶单调递减

#### 优化

1. 进行参数判断
