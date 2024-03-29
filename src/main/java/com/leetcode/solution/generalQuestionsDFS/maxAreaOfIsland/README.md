## 岛屿的最大面积

<https://leetcode.cn/problems/max-area-of-island/>

### 思路

二维矩阵 DFS => 求每个连通分量的面积 => 找到最大的

### 思路

| 问题行数 | 错误点             | 正确写法                                               | 错误原因   |
|------|-----------------|----------------------------------------------------|--------|
| 27   | return maxArea; | return maxArea == Integer.MIN_VALUE ? 0 : maxArea; | 有可能全是0 |

```java
class Solution {
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, -1, 0, 1};

    public int maxAreaOfIsland(int[][] grid) {
        // Ideas: get number of 1 in every connected component of the adjacency matrix
        // check input
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }

        // marked
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxArea = Integer.MIN_VALUE;

        // traversal
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int result = dfs(grid, i, j, visited);
                    maxArea = Math.max(maxArea, result);
                }
            }
        }
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }

    private int dfs(int[][] grid, int x, int y, boolean[][] visited) {
        // mark
        visited[x][y] = true;
        int result = 1;

        // move
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (checkRange(grid, newX, newY) && grid[newX][newY] == 1 && !visited[newX][newY]) {
                result += dfs(grid, newX, newY, visited);
            }
        }

        return result;
    }

    private boolean checkRange(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
```
