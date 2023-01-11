package com.leetcode.solution.dynamicProgramming.matrix.maximalSquare;

/**
 * https://leetcode.cn/problems/maximal-square/
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>
 * 示例 1：
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：matrix = [["0"]]
 * 输出：0
 */
abstract public class MaximalSquareTemplate {
    abstract public int maximalSquare(char[][] matrix);
}
