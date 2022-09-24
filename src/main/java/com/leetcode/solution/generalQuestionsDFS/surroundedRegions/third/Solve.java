package com.leetcode.solution.generalQuestionsDFS.surroundedRegions.third;

import com.leetcode.solution.generalQuestionsDFS.surroundedRegions.SolveTemplate;

public class Solve extends SolveTemplate {
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, -1, 0, 1};

    @Override
    public void solve(char[][] board) {
        // Ideas: adjacency matrix => get border O change B
        // check input
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        // marked
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        // traversal
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 此处不用判断 !visited[i][j] => 要把边缘 O 改为 B，是边缘 O 就一定没有访问过
                if (isBorder(board, i, j) && board[i][j] == 'O') {
                    dfs(board, i, j, visited);
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

    private void dfs(char[][] board, int x, int y, boolean[][] visited) {
        // mark
        visited[x][y] = true;
        board[x][y] = 'B';

        // move
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (checkRange(board, newX, newY) && !visited[newX][newY] && board[newX][newY] == 'O') {
                dfs(board, newX, newY, visited);
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
