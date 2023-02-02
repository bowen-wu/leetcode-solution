## 最大正方形

<https://leetcode.cn/problems/maximal-square/>

### 思路

1. DP 定位技巧
    1. 矩形 => 使用**左上角**坐标和**右下角**坐标
    2. 正方形 => 使用**右下角**坐标
2. 正方形拓展
    1. 边长为1拓展为边长为2
    2. 边长为2拓展为边长为3
    3. 边长为1拓展为边长为3
    4. 边长为1拓展为边长为n => 向上、向左、向左上
3. state => dp[i][j] 表示以(i, j)为右下角值全为1的正方形边长最大值
4. status function => dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
5. condition => dp[0][j] = matrix[0][j] dp[i][0] = matrix[i][0]
6. solution => max(dp[i][j]) ^ 2

### 总结

| 问题行数 | 错误点               | 正确写法 | 错误原因                          |
|------|-------------------|------|-------------------------------|
| -    | -                 | -    | check matrix[i][j] 是否为 '1'。思路 |
| 19   | 没有比较 dp[i % 2][0] | -    | 。大意                           |

```java
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[2][n];
        int max = 0;

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            max = Math.max(max, dp[0][j]);
        }

        for (int i = 1; i < m; i++) {
            dp[i % 2][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(max, dp[i % 2][0]);

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1], Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1])) + 1;
                    max = Math.max(max, dp[i % 2][j]);
                } else {
                    dp[i % 2][j] = 0;
                }
            }
        }

        return max * max;
    }
}
```
