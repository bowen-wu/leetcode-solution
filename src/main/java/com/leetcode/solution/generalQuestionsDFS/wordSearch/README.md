## 单词搜索

<https://leetcode.cn/problems/word-search/>

### 思路

二维问题 DFS

1. 从起始点找到下一个可以移动的点

### 总结

| 问题行数 | 错误点                                                     | 正确写法                                                     | 错误原因                    |
|------|---------------------------------------------------------|----------------------------------------------------------|-------------------------|
| 58   | private checkRange(int[][] board, int x, int y)         | private boolean checkRange(int[][] board, int x, int y)  | 没有写返回值。大意               |
| 58   | private boolean checkRange(int[][] board, int x, int y) | private boolean checkRange(char[][] board, int x, int y) | board 类型错误。大意           |
| 54   | -                                                       | visited[x][y] = false;                                   | 需要回溯 => 将节点置为false。思路问题 |

```java
class Solution {
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, -1, 0, 1};

    public boolean exist(char[][] board, String word) {
        // Ideas: DFS 二维矩阵
        // check input
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }

        // marked
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        // traversal
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && !visited[i][j]) {
                    if (dfs(board, word, 1, i, j, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int position, int x, int y, boolean[][] visited) {
        // exit recursion
        if (position >= word.length()) {
            return true;
        }

        // marked
        visited[x][y] = true;

        // traversal
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (checkRange(board, newX, newY) && !visited[newX][newY] && board[newX][newY] == word.charAt(position)) {
                if (dfs(board, word, position + 1, newX, newY, visited)) {
                    return true;
                }
            }
        }

        visited[x][y] = false;
        return false;
    }

    private boolean checkRange(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}
```
