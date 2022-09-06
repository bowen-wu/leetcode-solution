package com.leetcode.solution.generalQuestionsDFS.islandPerimeter.first;

import com.leetcode.solution.generalQuestionsDFS.islandPerimeter.IslandPerimeterTemplate;

public class IslandPerimeter extends IslandPerimeterTemplate {
    @Override
    public int islandPerimeter(int[][] grid) {
        // Ideas: 二维矩阵 DFS => 求得网格个数 => 周长 = 网格个数 * 4 - 重复的边 * 2
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        // marked
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        // 1 -> 网格个数 2 -> 重复的边
        int[] result = new int[2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j, result);
                }
            }
        }

        return result[0] * 4 - result[1] * 2;
    }

    private void dfs(int[][] grid, boolean[][] visited, int x, int y, int[] result) {
        // mark
        visited[x][y] = true;

        // move
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (checkRange(grid, newX, newY) && !visited[newX][newY] && grid[newX][newY] == 1) {
                result[0] += 1;


            }
        }
    }

    private boolean checkRange(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
