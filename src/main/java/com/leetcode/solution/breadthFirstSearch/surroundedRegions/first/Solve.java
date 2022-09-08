package com.leetcode.solution.breadthFirstSearch.surroundedRegions.first;

import com.leetcode.solution.breadthFirstSearch.surroundedRegions.SolveTemplate;

import java.util.LinkedList;
import java.util.Queue;

public class Solve extends SolveTemplate {
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, -1, 0, 1};

    @Override
    public void solve(char[][] board) {
        // Ideas: BFS => 从边界上的 O 做为起始点，将所有连接边界上的 O 改为 B
        // 遍历 board，将 O 改为 X 将 B 改为 O
        // check input
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        // marked
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        // bfs traversal
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O' && !visited[i][j]) {
                    bfs(board, visited, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                    continue;
                }
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(char[][] board, boolean[][] visited, int x, int y) {
        // queue
        Queue<Point> queue = new LinkedList<>();

        // offer & marked
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        // move
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            board[point.x][point.y] = 'B';
            for (int i = 0; i < 4; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];
                if (checkRange(board, newX, newY) && !visited[newX][newY] && board[newX][newY] == 'O') {
                    // offer & marked
                    queue.offer(new Point(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }

    private boolean checkRange(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
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
