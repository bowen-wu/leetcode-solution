## 矩阵中的最长递增路径

<https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/>

### 思路

1. 递增 => 下一个数字需要大于当前数字
2. 向四个方向做任意移动
3. DFS => 可以在 memory search =>
    1. init 0
    2. cannot move -1
    3. can move > 0

### 总结

| 问题行数 | 错误点                                       | 正确写法                                 | 错误原因                |
|------|-------------------------------------------|--------------------------------------|---------------------|
| 44   | result = Math.max(result, result + next); | result = Math.max(result, 1 + next); | 应该是当前节点数加上之后的节点数。思路 |
| 41   | int newY = x + dy[i];                     | int newY = y + dy[i];                | 大意                  |

```java
class Solution {
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, -1, 0, 1};

    public int longestIncreasingPath(int[][] matrix) {
        // Ideas: DFS -> 二维矩阵
        // check input
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        // memory search
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int result = Integer.MIN_VALUE;

        // traversal
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currentResult = dfs(memo, matrix, i, j);
                result = Math.max(result, currentResult);
            }
        }

        return result;
    }

    private int dfs(int[][] memo, int[][] matrix, int x, int y) {
        // hit cache
        if (memo[x][y] != 0) {
            return memo[x][y];
        }

        // result 
        int result = 1;

        // traversal
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (checkRange(matrix, newX, newY) && matrix[newX][newY] > matrix[x][y]) {
                int next = dfs(memo, matrix, newX, newY);
                result = Math.max(result, 1 + next);
            }
        }

        // update memo
        memo[x][y] = result;
        return result;
    }

    private boolean checkRange(int[][] matrix, int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }
}
```
