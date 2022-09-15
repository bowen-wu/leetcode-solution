package com.leetcode.solution.breadthFirstSearch.numberOfIslands.second;

import com.leetcode.solution.breadthFirstSearch.numberOfIslands.NumIslandsTemplate;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands extends NumIslandsTemplate {
    private final int[] dx = {0, -1, 0, 1};
    private final int[] dy = {-1, 0, 1, 0};

    @Override
    public int numIslands(char[][] grid) {
        // Ideas: BFS => get connect component => 二维矩阵
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
                    bfs(grid, i, j, visited);
                    connectComponentCount++;
                }
            }
        }

        return connectComponentCount;
    }

    private void bfs(char[][] grid, int x, int y, boolean[][] visited) {
        // queue
        Queue<int[]> queue = new LinkedList<>();

        // offer & marked
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        // traversal
        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            // move
            for (int i = 0; i < 4; i++) {
                int newX = point[0] + dx[i];
                int newY = point[1] + dy[i];
                if (checkRange(grid, newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') {
                    // offer & marked
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
    }

    private boolean checkRange(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
