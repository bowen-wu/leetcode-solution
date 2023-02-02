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

### 总结

| 问题行数 | 错误点                                                             | 正确写法                                                       | 错误原因 |
|------|-----------------------------------------------------------------|------------------------------------------------------------|------|
| 17   | dp[i % 2][0] = obstacleGrid[i][0] == 1 ? 0 : dp[(i - 1) % 2][0] | dp[i % 2][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0]; | 大意   |

```java
class Solution {
   public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
         return 0;
      }

      int m = obstacleGrid.length;
      int n = obstacleGrid[0].length;
      int[][] dp = new int[2][n];
      dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

      for (int j = 1; j < n; j++) {
         dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
      }

      for (int i = 1; i < m; i++) {
         dp[i % 2][0] = obstacleGrid[i][0] == 1 ? 0 : dp[(i - 1) % 2][0];

         for (int j = 1; j < n; j++) {
            dp[i % 2][j] = obstacleGrid[i][j] == 1 ? 0 : (dp[(i - 1) % 2][j] + dp[i % 2][j - 1]);
         }
      }

      return dp[(m - 1) % 2][n - 1];
   }
}
```
