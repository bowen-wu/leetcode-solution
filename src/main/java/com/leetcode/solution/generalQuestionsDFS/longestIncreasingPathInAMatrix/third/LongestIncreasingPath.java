package com.leetcode.solution.generalQuestionsDFS.longestIncreasingPathInAMatrix.third;

import com.leetcode.solution.generalQuestionsDFS.longestIncreasingPathInAMatrix.LongestIncreasingPathTemplate;

public class LongestIncreasingPath extends LongestIncreasingPathTemplate {
    private final int[] dx = {0, -1, 0, 1};
    private final int[] dy = {-1, 0, 1, 0};

    @Override
    public int longestIncreasingPath(int[][] matrix) {
        // Ideas: two dimensional matrix + memory search
        // check input
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return -1;
        }

        // memory search -> (x, y) -> int
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int max = Integer.MIN_VALUE;

        // traversal
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int result = dfs(matrix, i, j, memo);
                max = Math.max(max, result);
            }
        }

        return max;
    }

    private int dfs(int[][] matrix, int x, int y, int[][] memo) {
        // hit cache
        if (memo[x][y] != 0) {
            return memo[x][y];
        }

        // construc result
        int result = 1;

        // move
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (checkRange(matrix, newX, newY) && matrix[newX][newY] > matrix[x][y]) {
                int next = dfs(matrix, newX, newY, memo);
                result = Math.max(result, next + 1);
            }
        }

        // update memo
        memo[x][y] = result;
        return result;
    }

    private boolean checkRange(int[][] matrix, int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }
}
