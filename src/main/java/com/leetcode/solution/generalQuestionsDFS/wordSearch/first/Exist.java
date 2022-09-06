package com.leetcode.solution.generalQuestionsDFS.wordSearch.first;

import com.leetcode.solution.generalQuestionsDFS.wordSearch.ExistTemplate;

public class Exist extends ExistTemplate {
    @Override
    public boolean exist(char[][] board, String word) {
        // Ideas: 二维矩阵 DFS
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
                if (board[i][j] == word.charAt(0) && !visited[i][j]) {
                    boolean singleResult = dfs(board, word, 0, visited, i, j);
                    if (singleResult) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int position, boolean[][] visited, int x, int y) {
        // pruning
        if (board[x][y] != word.charAt(position)) {
            return false;
        }

        // exit recursion
        if (position == word.length() - 1) {
            return true;
        }

        // marked
        visited[x][y] = true;

        // move
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            if (checkRange(x + dx[i], y + dy[i], board) && !visited[x + dx[i]][y + dy[i]]) {
                boolean singleResult = dfs(board, word, position + 1, visited, x + dx[i], y + dy[i]);
                if (singleResult) {
                    return true;
                }
            }
        }

        visited[x][y] = false;
        return false;
    }

    private boolean checkRange(int x, int y, char[][] board) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}
