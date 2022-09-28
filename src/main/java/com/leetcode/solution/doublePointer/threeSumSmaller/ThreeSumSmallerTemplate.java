package com.leetcode.solution.doublePointer.threeSumSmaller;

/**
 * https://leetcode.cn/problems/3sum-smaller/
 * 259. 较小的三数之和
 * 给定一个长度为 n 的整数数组和一个目标值 target，寻找能够使条件nums[i] + nums[j] + nums[k] < target成立的三元组 i, j, k个数（0 <= i < j < k < n）。
 * <p>
 * 示例 1：
 * 输入: nums = [-2,0,1,3], target = 2
 * 输出: 2
 * 解释: 因为一共有两个三元组满足累加和小于 2:
 * [-2,0,1]
 * [-2,0,3]
 * <p>
 * 示例 2：
 * 输入: nums = [], target = 0
 * 输出: 0
 * <p>
 * 示例 3：
 * 输入: nums = [0], target = 0
 * 输出: 0
 */
abstract public class ThreeSumSmallerTemplate {
    abstract public int threeSumSmaller(int[] nums, int target);
}
