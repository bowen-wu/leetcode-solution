package com.leetcode.solution.generalQuestionsDFS.surroundedRegions.second;

import com.leetcode.solution.generalQuestionsDFS.surroundedRegions.SolveTemplate;

public class Solve extends SolveTemplate {
    private final int[] dx = {0, -1, 0, 1};
    private final int[] dy = {1, 0, -1, 0};

    @Override
    public void solve(char[][] board) {
        // Ideas: DFS => 二维矩阵	 => traversal from border, O -> B => traversal board O -> X, B -> O
        // check input
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        // marked
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isBorder(board, i, j) && board[i][j] == 'O' && !visited[i][j]) {
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
        // marked
        visited[x][y] = true;
        board[x][y] = 'B';

        // traversal
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (checkRange(board, newX, newY) && !visited[newX][newY] && board[newX][newY] == 'O') {
                dfs(board, newX, newY, visited);
            }
        }
    }

    private boolean isBorder(char[][] board, int x, int y) {
        return x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1;
    }

    private boolean checkRange(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}
