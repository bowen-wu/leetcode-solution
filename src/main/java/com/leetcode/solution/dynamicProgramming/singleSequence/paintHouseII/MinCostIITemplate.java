package com.leetcode.solution.dynamicProgramming.singleSequence.paintHouseII;

/**
 * https://leetcode.cn/problems/paint-house-ii/
 * 265. 粉刷房子 II
 * 假如有一排房子共有n幢，每个房子可以被粉刷成 k种颜色中的一种。房子粉刷成不同颜色的花费成本也是不同的。你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * 每个房子粉刷成不同颜色的花费以一个 n x k 的矩阵表示。
 * 例如，costs[0][0] 表示第 0幢房子粉刷成 0 号颜色的成本；costs[1][2]表示第 1 幢房子粉刷成 2 号颜色的成本，以此类推。
 * 返回 粉刷完所有房子的最低成本。
 * <p>
 * 示例 1：
 * 输入: costs = [[1,5,3],[2,9,4]]
 * 输出: 5
 * 解释:
 * 将房子 0 刷成 0 号颜色，房子 1 刷成 2 号颜色。花费: 1 + 4 = 5;
 * 或者将 房子 0 刷成 2 号颜色，房子 1 刷成 0 号颜色。花费: 3 + 2 = 5.
 * <p>
 * 示例2:
 * 输入: costs = [[1,3],[2,4]]
 * 输出: 5
 */
abstract public class MinCostIITemplate {
    abstract public int minCostII(int[][] costs);

    abstract public int minCostIIFromI(int[][] costs);
}
