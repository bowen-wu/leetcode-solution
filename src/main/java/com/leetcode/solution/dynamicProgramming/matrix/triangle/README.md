## 三角形最小路径和

<https://leetcode.cn/problems/triangle/>

### 思路

1. 制表法
2. state => dp[i][j] 表示顶点到 (i, j) 位置的最小路径和
3. status function => dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j] => check i - 1 & j - 1
4. condition => dp[0][0] = triangle[0][0]
5. solution => Math.min(dp[len])

### 总结

1. 需要获取最后一行的最小值

| 问题行数 | 错误点                                                     | 正确写法           | 错误原因 |
|------|---------------------------------------------------------|----------------|------|
| 31   | return result == Integer.MAX_VALUE ? dp[0][0] : result; | return result; | 大意   |

```java
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0) == null || triangle.get(0).size() == 0) {
            return 0;
        }

        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[2][n];
        dp[0][0] = triangle.get(0).get(0);
        int result = Integer.MAX_VALUE;

        for (int i = 1; i < m; i++) {
            int size = triangle.get(i).size();
            for (int j = 0; j < size; j++) {
                int currentValue = triangle.get(i).get(j);
                if (j == 0) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j] + currentValue;
                } else if (j == size - 1) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + currentValue;
                } else {
                    dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1], dp[(i - 1) % 2][j]) + currentValue;
                }

                if (i == m - 1) {
                    result = Math.min(result, dp[i % 2][j]);
                }
            }
        }

        return result == Integer.MAX_VALUE ? dp[0][0] : result;
    }
}
```






