package com.leetcode.solution.generalQuestionsDFS.maxAreaOfIsland.first;

import com.leetcode.solution.generalQuestionsDFS.maxAreaOfIsland.MaxAreaOfIslandTemplate;

public class MaxAreaOfIsland extends MaxAreaOfIslandTemplate {
    @Override
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return maxArea;
        }

        // marked
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, dfs(grid, visited, i, j));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] visited, int x, int y) {
        // pruning
        if (grid[x][y] != 1) {
            return 0;
        }

        // construct result
        int count = 1;

        // marked
        visited[x][y] = true;

        // move
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (checkRange(grid, newX, newY) && !visited[newX][newY]) {
                count += dfs(grid, visited, newX, newY);
            }
        }

        return count;
    }

    private boolean checkRange(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
