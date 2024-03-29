package com.leetcode.solution.stack.largestRectangleInHistogram;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 84. 柱状图中最大的矩形
 * 给定n个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 示例 1:
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * <p>
 * 示例 2：
 * 输入： heights = [2,4]
 * 输出： 4
 */
abstract public class LargestRectangleAreaTemplate {
    abstract public int largestRectangleArea(int[] heights);

    abstract public int largestRectangleAreaBruteForce(int[] heights);

    abstract public int largestRectangleAreaWhenPop(int[] heights);

    abstract public int largestRectangleAreaOfTwoNextGreaterNumber(int[] heights);
}
