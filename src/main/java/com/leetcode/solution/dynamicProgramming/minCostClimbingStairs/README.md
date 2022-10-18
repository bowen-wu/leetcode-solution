## 使用最小花费爬楼梯

<https://leetcode.cn/problems/min-cost-climbing-stairs/>

### 思路

1. State => f(n) 表示达到第 n 阶台阶的最少花费
2. Function => f(n) = Math.min(f(n - 1) + 第 n - 1 阶的花费, f(n - 2) + 第 n - 2 阶的花费)
3. Condition => 
4. Solution => 求 f(n)

