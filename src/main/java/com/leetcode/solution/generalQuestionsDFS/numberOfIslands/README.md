## 岛屿数量

<https://leetcode.cn/problems/number-of-islands/>

### 思路

二维矩阵 DFS => 求连通分量

### 总结

| 问题行数 | 错误点                                                                                  | 正确写法                                                                                 | 错误原因 |
|------|--------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------|------|
| 38   | if (chackRange(grid, newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') | if (checkRange(grid, newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') | 笔误   |

```java
class Solution {
    private final int[] dx = {0, -1, 0, 1};
    private final int[] dy = {-1, 0, 1, 0};

    public int numIslands(char[][] grid) {
        // Ideas: DFS => 二维矩阵求连通分量
        // check input
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        // marked
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int connectComponentCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    connectComponentCount++;
                }
            }
        }

        return connectComponentCount;
    }

    private void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        // marked
        visited[x][y] = true;

        // traversal
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (checkRange(grid, newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') {
                dfs(grid, visited, newX, newY);
            }
        }
    }

    private boolean checkRange(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
```
