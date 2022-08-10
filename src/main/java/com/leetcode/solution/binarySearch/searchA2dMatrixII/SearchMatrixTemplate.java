package com.leetcode.solution.binarySearch.searchA2dMatrixII;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索mxn矩阵中的一个目标值target。
 * 该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 例如，
 * 考虑下面的矩阵：
 * [ [1, 4, 7, 11, 15],
 *  [2, 5, 8, 12, 19],
 *  [3, 6, 9, 16, 22],
 *  [10, 13, 14, 17, 24],
 *  [18, 21, 23, 26, 30] ]
 * 给定目标值target=5, 返回true。
 * 给定目标值target=20, 返回false。
 */
abstract public class SearchMatrixTemplate {
    abstract public boolean searchMatrix(int[][] matrix, int target);
}
