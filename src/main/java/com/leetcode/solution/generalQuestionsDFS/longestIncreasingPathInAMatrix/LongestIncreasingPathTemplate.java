package com.leetcode.solution.generalQuestionsDFS.longestIncreasingPathInAMatrix;

/**
 * https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/
 * 329. 矩阵中的最长递增路径
 * 给定一个m x n 整数矩阵matrix ，找出其中 最长递增路径 的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 * <p>
 * 示例 1：
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4
 * 解释：最长递增路径为[1, 2, 6, 9]。
 * <p>
 * 示例 2：
 * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * 输出：4
 * 解释：最长递增路径是[3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * <p>
 * 示例 3：
 * 输入：matrix = [[1]]
 * 输出：1
 */
abstract public class LongestIncreasingPathTemplate {
    abstract public int longestIncreasingPath(int[][] matrix);
}
