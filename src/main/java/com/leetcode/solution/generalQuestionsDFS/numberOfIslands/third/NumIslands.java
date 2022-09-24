package com.leetcode.solution.generalQuestionsDFS.numberOfIslands.third;

import com.leetcode.solution.generalQuestionsDFS.numberOfIslands.NumIslandsTemplate;


public class NumIslands extends NumIslandsTemplate {
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, -1, 0, 1};

    @Override
    public int numIslands(char[][] grid) {
        // Ideas: get connect component count in adjacency matrix
        // check input
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        // marked
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int connectComponentCount = 0;

        // traversal
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    connectComponentCount++;
                }
            }
        }
        return connectComponentCount;
    }

    private void dfs(char[][] grid, int x, int y, boolean[][] visited) {
        // marked
        visited[x][y] = true;

        // move
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (checkRange(grid, newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') {
                dfs(grid, newX, newY, visited);
            }
        }
    }

    private boolean checkRange(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
