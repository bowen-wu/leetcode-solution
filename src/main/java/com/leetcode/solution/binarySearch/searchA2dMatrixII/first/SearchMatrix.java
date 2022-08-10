package com.leetcode.solution.binarySearch.searchA2dMatrixII.first;

import com.leetcode.solution.binarySearch.searchA2dMatrixII.SearchMatrixTemplate;

public class SearchMatrix extends SearchMatrixTemplate {
    @Override
    public boolean searchMatrix(int[][] matrix, int target) {
        // 时间复杂度：O(logn)
        // 空间复杂度：O(1)
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        // 右上角 => 最小行，最大列
        //    - 向左递减
        //    - 向下递增
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        while (row < m && col >= 0) {
            if (target > matrix[row][col]) {
                row++;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }
}
