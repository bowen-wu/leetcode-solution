package com.leetcode.solution.breadthFirstSearch.surroundedRegions.third;

import com.leetcode.solution.breadthFirstSearch.surroundedRegions.SolveTemplate;

import java.util.LinkedList;
import java.util.Queue;

public class Solve extends SolveTemplate {
    private final int[] dx = {0, -1, 0, 1};
    private final int[] dy = {-1, 0, 1, 0};

    @Override
    public void solve(char[][] board) {
        // Ideas: BFS => two dimensional matrix => border O change to B
        // check input
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        // mark
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        // traversal
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isBorder(board, i, j) && board[i][j] == 'O') {
                    bfs(board, i, j, visited);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(char[][] board, int x, int y, boolean[][] visited) {
        // queue
        Queue<int[]> queue = new LinkedList<>();

        // offer & mark
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        // traversal
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            board[point[0]][point[1]] = 'B';

            for (int i = 0; i < 4; i++) {
                int newX = point[0] + dx[i];
                int newY = point[1] + dy[i];
                if (checkRange(board, newX, newY) && board[newX][newY] == 'O' && !visited[newX][newY]) {
                    // offer & mark
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
    }

    private boolean checkRange(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    private boolean isBorder(char[][] board, int x, int y) {
        return x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1;
    }
}
