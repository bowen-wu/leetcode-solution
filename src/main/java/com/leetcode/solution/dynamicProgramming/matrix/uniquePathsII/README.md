## 不同路径 II

<https://leetcode.cn/problems/unique-paths-ii/>

### 思路

1. state => dp[i][j] 表示左上角到 (i, j) 点的路径数
2. status function => dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : (dp[i - 1][j] + dp[i][j - 1])
3. condition => 需要查看是否是1
    - dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1
    - dp[[1, m)][0] = obstacleGrid[<index>][0] == 1 ? 0 : dp[<index> - 1][0];
    - dp[0][[1, n)] = obstacleGrid[0][<index>] == 1 ? 0 : dp[0][<index>];
4. solution => dp[m - 1][n - 1]
