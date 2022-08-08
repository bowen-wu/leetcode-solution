package com.leetcode.solution.stackAndQueue.largestRectangleInHistogram;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 84. 柱状图中最大的矩形
 * 给定n个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
abstract public class LargestRectangleAreaTemplate {
    abstract public int largestRectangleArea(int[] heights);

    abstract public int largestRectangleAreaBruteForce(int[] heights);

    abstract public int largestRectangleAreaWhenPop(int[] heights);

    abstract public int largestRectangleAreaOfTwoNextGreaterNumber(int[] heights);
}
