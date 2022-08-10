package com.leetcode.solution.array.numMatrix.third;

import com.leetcode.solution.array.numMatrix.NumMatrixTemplate;

public class NumMatrix extends NumMatrixTemplate {
    // 思路：
    // 1. Brute Force => O(m * n)
    // 2. 一维数组前缀和 => 初始化的时候每一行做前缀和。获取的时候 interval[i, j] = prefixSum[j + 1] - prefixSum[i] => O(m * n) + O(n)
    // 3. 二维数组前缀和 => 初始化的时候做二维数组前缀和。prefixSum[i + 1, j + 1] 表示 [0, 0] 到 [i, j] 的面积 => O(m * n) + O(1)

    private final int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            throw new RuntimeException("The param of matrix is invalid!");
        }
        int m = matrix.length;
        int n = matrix[0].length;
        prefixSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixSum[i + 1][j + 1] = prefixSum[i][j + 1] + prefixSum[i + 1][j] - prefixSum[i][j] + matrix[i][j];
            }
        }
    }

    @Override
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2 + 1][col2 + 1] - prefixSum[row2 + 1][col1] - prefixSum[row1][col2 + 1] + prefixSum[row1][col1];
    }
}
