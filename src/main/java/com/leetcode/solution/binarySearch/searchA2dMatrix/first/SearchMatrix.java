package com.leetcode.solution.binarySearch.searchA2dMatrix.first;

import com.leetcode.solution.binarySearch.searchA2dMatrix.SearchMatrixTemplate;

public class SearchMatrix extends SearchMatrixTemplate {
    @Override
    public boolean searchMatrix(int[][] matrix, int target) {
        // 时间复杂度：O(log(m*n))
        // 空间复杂度：O(1)
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int start = 0;
        int end = rowLen * colLen - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target > matrix[mid / colLen][mid % colLen]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return matrix[start / colLen][start % colLen] == target || matrix[end / colLen][end / colLen] == target;
    }

    public boolean searchMatrixForTwoBinarySearch(int[][] matrix, int target) {
        // 时间复杂度：O(logm) + O(logn)
        // 空间复杂度：O(1)
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int start = 0;
        int end = matrix.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target > matrix[mid][0]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[start][0] == target || matrix[end][0] == target) {
            return true;
        }
        if (matrix[start][0] > target) {
            return false;
        }

        int row = matrix[end][0] < target ? end : start;
        start = 0;
        end = matrix[row].length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target > matrix[row][mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return matrix[row][start] == target || matrix[row][end] == target;
    }
}
