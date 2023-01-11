## 不同路径

<https://leetcode.cn/problems/unique-paths/>

### 思路

1. state => dp[i][j] 代表从左上角到 (i, j) 位置的路径总数
2. status function => dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
3. condition => dp[0][[0, n)] = 1 & dp[[0, m)][0] = 1
4. solution => dp[m - 1][n - 1]

#### 优化

1. 滚动数组优化 => dp[2][n]
