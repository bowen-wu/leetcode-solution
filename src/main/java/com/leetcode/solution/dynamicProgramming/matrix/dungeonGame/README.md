## 地下城游戏

<https://leetcode.cn/problems/dungeon-game/>

### 思路

1. 从右下角往左上角移动
2. state => dp[i][j] 表示从右下角到 (i, j) 位置能够存活的最小 HP
3. status function => dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + dungeon[i][j]
4. condition => dp[m][(n, 0]] + dp[(m, 0]][n]
5. solution => dp[0][0]
