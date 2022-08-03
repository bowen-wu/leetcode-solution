package com.leetcode.solution.array.numMatrix.first;

import com.leetcode.solution.array.numMatrix.NumMatrixTemplate;

public class NumMatrix extends NumMatrixTemplate {

    private final int[][] matrix;
    private final int[][] oneDimensionalPrefixSumMatrix;
    private final int[][] twoDimensionalPrefixSumMatrix;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            throw new RuntimeException("参数不合法");
        }

        this.matrix = matrix;
        this.oneDimensionalPrefixSumMatrix = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            int[] oneDimensionalPrefixSum = new int[matrix[i].length + 1];
            for (int j = 0; j < matrix[i].length; j++) {
                oneDimensionalPrefixSum[j + 1] = oneDimensionalPrefixSum[j] + matrix[i][j];
            }
            oneDimensionalPrefixSumMatrix[i] = oneDimensionalPrefixSum;
        }

        // 二位前缀和 twoDimensionalPrefixSumMatrix[row + 1][col + 1] 代表原点(0, 0)为左上顶点，(row, col)为右下顶点的矩阵内的所有元素之和
        // twoDimensionalPrefixSumMatrix[i + 1][j + 1] = twoDimensionalPrefixSumMatrix[i][j + 1] + twoDimensionalPrefixSumMatrix[i + 1][j] - twoDimensionalPrefixSumMatrix[i][j] + matrix[i][j]
        // 时间复杂度：O(m * n)
        // 空间复杂度：O(m * n)
        this.twoDimensionalPrefixSumMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                twoDimensionalPrefixSumMatrix[row + 1][col + 1] = twoDimensionalPrefixSumMatrix[row][col + 1] + twoDimensionalPrefixSumMatrix[row + 1][col] - twoDimensionalPrefixSumMatrix[row][col] + matrix[row][col];
            }
        }
    }

    @Override
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 二位前缀和 length 比数组长 1 个
        return twoDimensionalPrefixSumMatrix[row2 + 1][col2 + 1] - twoDimensionalPrefixSumMatrix[row1][col2 + 1] - twoDimensionalPrefixSumMatrix[row2 + 1][col1] + twoDimensionalPrefixSumMatrix[row1][col1];
    }

    public int sumRegionOneDimensional(int row1, int col1, int row2, int col2) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (row2 >= matrix.length || col2 >= matrix[0].length) {
            return 0;
        }

        int result = 0;
        for (int row = row1; row <= row2; row++) {
            result += oneDimensionalPrefixSumMatrix[row][col2 + 1] - oneDimensionalPrefixSumMatrix[row][col1];
        }

        return result;
    }

    public int sumRegionBruteForce(int row1, int col1, int row2, int col2) {
        // 时间复杂度：O((row2 - row1) * (col2 - col1)) => O(n^2)
        // 空间复杂度：O(1)
        if (row2 >= matrix.length || col2 >= matrix[0].length) {
            return 0;
        }
        int result = 0;
        for (int row = row1; row <= row2; row++) {
            for (int col = col1; col <= col2; col++) {
                result += matrix[row][col];
            }
        }
        return result;
    }
}
