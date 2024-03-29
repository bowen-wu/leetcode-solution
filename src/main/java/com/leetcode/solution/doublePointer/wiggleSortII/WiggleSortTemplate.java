package com.leetcode.solution.doublePointer.wiggleSortII;

/**
 * https://leetcode.cn/problems/wiggle-sort-ii/
 * 324. 摆动排序 II
 * 给你一个整数数组nums，将它重新排列成nums[0] < nums[1] > nums[2] < nums[3]...的顺序。
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 * <p>
 * 示例 1：
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * <p>
 * 示例 2：
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 */
abstract public class WiggleSortTemplate {
    abstract public void wiggleSort(int[] nums);
}
