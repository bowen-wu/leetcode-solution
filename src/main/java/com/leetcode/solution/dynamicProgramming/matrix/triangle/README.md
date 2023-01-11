## 三角形最小路径和

<https://leetcode.cn/problems/triangle/>

### 思路

1. 制表法
2. state => dp[i][j] 表示顶点到 (i, j) 位置的最小路径和
3. status function => dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j] => check i - 1 & j - 1
4. condition => dp[0][0] = triangle[0][0]
5. solution => Math.min(dp[len])
