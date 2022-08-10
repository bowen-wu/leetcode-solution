package com.leetcode.solution.binarySearch.searchA2dMatrix;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix/
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来搜索mxn矩阵中的一个目标值。
 * 该矩阵具有以下特性：
 * 每行中的整数从左到右排序。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 例如，
 * 以下矩阵：
 * [
 * [1, 3, 5, 7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * 给定目标值=3，返回true。
 */
abstract public class SearchMatrixTemplate {
    abstract public boolean searchMatrix(int[][] matrix, int target);
}
