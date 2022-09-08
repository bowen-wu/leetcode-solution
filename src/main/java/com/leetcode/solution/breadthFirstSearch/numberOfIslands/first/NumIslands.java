package com.leetcode.solution.breadthFirstSearch.numberOfIslands.first;

import com.leetcode.solution.breadthFirstSearch.numberOfIslands.NumIslandsTemplate;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands extends NumIslandsTemplate {
    private final int[] dx = {0, -1, 0, 1};
    private final int[] dy = {1, 0, -1, 0};

    @Override
    public int numIslands(char[][] grid) {
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
                    bfs(grid, visited, i, j);
                    connectComponentCount++;
                }
            }
        }

        return connectComponentCount;
    }

    private void bfs(char[][] grid, boolean[][] visited, int x, int y) {
        // queue
        Queue<Point> queue = new LinkedList<>();

        // offer & marked
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        // move
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];
                if (checkRange(grid, newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') {
                    // offer & marked
                    queue.offer(new Point(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }

    private boolean checkRange(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
