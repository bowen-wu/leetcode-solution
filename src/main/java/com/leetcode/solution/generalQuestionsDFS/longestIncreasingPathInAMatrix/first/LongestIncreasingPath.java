package com.leetcode.solution.generalQuestionsDFS.longestIncreasingPathInAMatrix.first;

import com.leetcode.solution.generalQuestionsDFS.longestIncreasingPathInAMatrix.LongestIncreasingPathTemplate;

public class LongestIncreasingPath extends LongestIncreasingPathTemplate {
    private final int[] dx = {0, -1, 0, 1};
    private final int[] dy = {-1, 0, 1, 0};

    @Override
    public int longestIncreasingPath(int[][] matrix) {
        // Ideas: 二维问题
        // check input
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        // memory search
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (memo[i][j] == 0) {
                    memo[i][j] = dfs(matrix, memo, i, j);
                }

                result = Math.max(result, memo[i][j]);
            }
        }

        return result;
    }

    private int dfs(int[][] matrix, int[][] memo, int x, int y) {
        // hit cache
        if (memo[x][y] != 0) {
            return memo[x][y];
        }

        // construct result
        int result = 1;

        // recursion decomposition sub problem to next level + pruning
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (checkRange(matrix, newX, newY) && matrix[newX][newY] > matrix[x][y]) {
                result = Math.max(result, dfs(matrix, memo, newX, newY) + 1);
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
