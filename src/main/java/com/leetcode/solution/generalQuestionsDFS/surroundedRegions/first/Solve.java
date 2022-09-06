package com.leetcode.solution.generalQuestionsDFS.surroundedRegions.first;

import com.leetcode.solution.generalQuestionsDFS.surroundedRegions.SolveTemplate;

import java.util.ArrayList;
import java.util.List;

public class Solve extends SolveTemplate {
    public static void main(String[] args) {
        new Solve().solve(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}});
    }

    @Override
    public void solve(char[][] board) {
        // Ideas: 从边界的 O 的连通分量的 O 不变，其余的变为 X
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        // marked
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O' && !visited[i][j]) {
                    dfs(board, i, j, visited);
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
                    continue;
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y, boolean[][] visited) {
        // pruning
        if (board[x][y] == 'X') {
            return;
        }

        // marked
        visited[x][y] = true;
        board[x][y] = 'B';

        // move
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            if (checkRange(board, x + dx[i], y + dy[i]) && !visited[x + dx[i]][y + dy[i]]) {
                dfs(board, x + dx[i], y + dy[i], visited);
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

    public void solveOvertime(char[][] board) {
        // Ideas: 1. 拿到所有 o 的坐标，之后如果 list 中的 o 都不在边界，则替换
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        // marked
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        List<List<Point>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    result.add(dfsOvertime(board, i, j, visited));
                }
            }
        }
        result.forEach(path -> {
            if (path.stream().noneMatch(point -> point.x == 0 || point.y == 0 || point.x == m - 1 || point.y == n - 1)) {
                path.forEach(point -> board[point.x][point.y] = 'X');
            }
        });
    }

    private List<Point> dfsOvertime(char[][] board, int x, int y, boolean[][] visited) {
        // pruning
        if (board[x][y] == 'X') {
            return new ArrayList<>();
        }

        // contract result
        List<Point> result = new ArrayList<>();

        // marked
        visited[x][y] = true;
        result.add(new Point(x, y));

        // move
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (checkRange(board, newX, newY) && !visited[newX][newY]) {
                result.addAll(dfsOvertime(board, newX, newY, visited));
            }
        }
        return result;
    }
}
