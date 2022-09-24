package com.leetcode.solution.generalQuestionsDFS.wordSearch.third;

import com.leetcode.solution.generalQuestionsDFS.wordSearch.ExistTemplate;

public class Exist extends ExistTemplate {
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, -1, 0, 1};

    @Override
    public boolean exist(char[][] board, String word) {
        // Ideas: two dimensional matrix
        // check input
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }

        // marked
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 1, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int position, boolean[][] visited) {
        // exit recursion
        if (position >= word.length()) {
            return true;
        }

        // marked
        visited[x][y] = true;

        // move
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (checkRange(board, newX, newY) && !visited[newX][newY] && board[newX][newY] == word.charAt(position)) {
                if (dfs(board, newX, newY, word, position + 1, visited)) {
                    return true;
                }
            }
        }

        // reset
        visited[x][y] = false;
        return false;
    }

    private boolean checkRange(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}
