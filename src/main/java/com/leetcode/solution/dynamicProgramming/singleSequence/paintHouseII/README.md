## 粉刷房子 II

<https://leetcode.cn/problems/paint-house-ii/>

### 思路

1. state => dp[i][k] 使用k颜色粉刷第i个房子的最小花费
2. status function => dp[i][k] = min(dp[i - 1][j])(j != k) + cost[i][k]
3. condition => dp[0][k] = cost[0][k] k == 0 -> k
4. solution => min(dp[costs.length - 1][k])
5. 时间复杂度 => O(n * k * k)

#### 优化

1. 时间复杂度 => O(n * k)
2. 记录一个 minCost 和 secondMinCost
