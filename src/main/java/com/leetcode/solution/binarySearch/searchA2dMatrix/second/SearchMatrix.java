package com.leetcode.solution.binarySearch.searchA2dMatrix.second;

import com.leetcode.solution.binarySearch.searchA2dMatrix.SearchMatrixTemplate;

public class SearchMatrix extends SearchMatrixTemplate {
    // 思路：m * n 二维矩阵是一个递增的序列，使用二分查找。
    // 		坐标 (x, y) 转数字 => x * n + y
    //      数字 num 转坐标 => (num / n, num % n)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int colLen = matrix[0].length;
        int start = 0;
        int end = matrix.length * matrix[0].length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target > matrix[mid / colLen][mid % colLen]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return target == matrix[start / colLen][start % colLen] || target == matrix[end / colLen][end % colLen];
    }
}
