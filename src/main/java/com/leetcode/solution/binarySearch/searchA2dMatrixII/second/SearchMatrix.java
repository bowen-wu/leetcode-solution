package com.leetcode.solution.binarySearch.searchA2dMatrixII.second;

import com.leetcode.solution.binarySearch.searchA2dMatrixII.SearchMatrixTemplate;

public class SearchMatrix extends SearchMatrixTemplate {
    // 思路：选取右上角做为切入点，右上角特性，向左依次递减，向下依次递增
    @Override
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int x = 0;
        int y = matrix[0].length - 1;

        while (x < matrix.length && y >= 0) {
            if (target > matrix[x][y]) {
                x++;
            } else if (target == matrix[x][y]) {
                return true;
            } else {
                y--;
            }
        }

        return false;
    }
}
