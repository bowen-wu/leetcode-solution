## 爬楼梯

<https://leetcode.cn/problems/climbing-stairs/>

### 思路

1. DP
2. State => f(n) 表示爬到第 n 阶有多少种方法
3. Function => f(n) = = f(n - 1) + f(n - 2)
4. Condition =>
    1. f(1) = 1
    2. f(2) = 2
5. Solution => 求 f(n)

#### 优化

1. 如果是用滚动数组，memo[0] = 1
