package com.leetcode.solution.array.numMatrix.second;

import com.leetcode.solution.array.numMatrix.NumMatrixTemplate;

public class NumMatrix extends NumMatrixTemplate {
    private final int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        // 思路：数组前缀和
        // 时间复杂度：O(m * n)
        // 空间复杂度：O(m * n)
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new RuntimeException("The matrix is invalid!");
        }

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        prefixSum = new int[rowLength + 1][colLength + 1];
        // prefixSum[i + 1][j + 1] 表示 [0][0] 到[i][j] 的面积
        // prefixSum[row][col] = prefixSum[row - 1][col] + prefixSum[row][col - 1] - prefixSum[row - 1][col - 1] + matrix[row][col]
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                prefixSum[row + 1][col + 1] = prefixSum[row][col + 1] + prefixSum[row + 1][col] - prefixSum[row][col] + matrix[row][col];
            }
        }
    }

    @Override
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 时间复杂度：O(1)
        return prefixSum[row2 + 1][col2 + 1] - prefixSum[row1][col2 + 1] - prefixSum[row2 + 1][col1] + prefixSum[row1][col1];
    }
}
