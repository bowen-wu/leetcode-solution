## 粉刷房子

<https://leetcode.cn/problems/paint-house/>

### 思路

1. State => dp[i][k] 表示使用k颜色粉刷第i个房子的最小花费
2. Status Function => dp[i][k] = min(dp[i - 1][j])(j != k) + costs[i][k]
3. Condition => dp[0][0] = costs[0][0] dp[0][1] = costs[0][1] dp[0][2] = costs[0][2]
4. Solution => min(dp[length][0], dp[length][1], dp[length][2])
