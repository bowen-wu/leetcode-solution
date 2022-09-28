package com.leetcode.solution.doublePointer.validTriangleNumber;

/**
 * https://leetcode.cn/problems/valid-triangle-number/
 * 611. 有效三角形的个数
 * 给定一个包含非负整数的数组nums ，返回其中可以组成三角形三条边的三元组个数。
 * <p>
 * 示例 1:
 * 输入: nums = [2,2,3,4]
 * 输出: 3
 * 解释:有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * <p>
 * 示例 2:
 * 输入: nums = [4,2,3,4]
 * 输出: 4
 */
abstract public class TriangleNumberTemplate {
    abstract public int triangleNumber(int[] nums);
}
