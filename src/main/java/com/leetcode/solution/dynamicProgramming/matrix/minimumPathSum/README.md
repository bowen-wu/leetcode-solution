## 最小路径和

<https://leetcode.cn/problems/minimum-path-sum/>

### 思路

1. 制表法
2. state => dp[i][j] 表示左上角到 (i, j) 位置路径最小值
3. status function => dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
4. condition => dp[[0, m)][0] & dp[0][[0, n)]
5. solution => dp[m - 1][n - 1]

#### 优化

滚动数组
