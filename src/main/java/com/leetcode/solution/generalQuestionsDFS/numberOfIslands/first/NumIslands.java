package com.leetcode.solution.generalQuestionsDFS.numberOfIslands.first;

import com.leetcode.solution.generalQuestionsDFS.numberOfIslands.NumIslandsTemplate;

public class NumIslands extends NumIslandsTemplate {
    @Override
    public int numIslands(char[][] grid) {
        // Ideas: 二维矩阵求连通分量
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int count = 0;

        // marked
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        // pruning
        if (grid[x][y] != '1') {
            return;
        }

        // marked
        visited[x][y] = true;

        // move
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            if (checkRange(grid, x + dx[i], y + dy[i]) && !visited[x + dx[i]][y + dy[i]]) {
                dfs(grid, visited, x + dx[i], y + dy[i]);
            }
        }
    }

    private boolean checkRange(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
