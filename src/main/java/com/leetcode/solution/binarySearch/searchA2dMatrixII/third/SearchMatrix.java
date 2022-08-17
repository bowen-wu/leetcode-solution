package com.leetcode.solution.binarySearch.searchA2dMatrixII.third;

import com.leetcode.solution.binarySearch.searchA2dMatrixII.SearchMatrixTemplate;

public class SearchMatrix extends SearchMatrixTemplate {
    @Override
    public boolean searchMatrix(int[][] matrix, int target) {
        // 思路：从右上角或左下角出发 => row = 0 col = matrix[0].length - 1
        // 右上角 => target > current => row++ target < current col--
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int row = 0;
        int col = colLen - 1;
        while (row < rowLen && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            }
            if (target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }
}
