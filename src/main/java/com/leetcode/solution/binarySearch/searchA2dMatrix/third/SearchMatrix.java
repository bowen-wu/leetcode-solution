package com.leetcode.solution.binarySearch.searchA2dMatrix.third;

import com.leetcode.solution.binarySearch.searchA2dMatrix.SearchMatrixTemplate;

public class SearchMatrix extends SearchMatrixTemplate {
    @Override
    public boolean searchMatrix(int[][] matrix, int target) {
        // 思路：坐标转化 => n + colLen=> (n / colLen, n % colLen)
        // (x, y) => x * colLen + y
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int colLen = matrix[0].length;
        int start = 0;
        int end = matrix.length * colLen - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target > matrix[mid / colLen][mid % colLen]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return matrix[start / colLen][start % colLen] == target || matrix[end / colLen][end % colLen] == target;
    }

    public boolean searchMatrixTwice(int[][] matrix, int target) {
        // 思路：先按第一列二分查找，确定行了之后，在这个行进行二分查找
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int start = 0;
        int end = matrix.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        int rowNum = matrix[end][0] > target ? start : end;
        start = 0;
        end = matrix[0].length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[rowNum][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return matrix[rowNum][start] == target || matrix[rowNum][end] == target;
    }
}
