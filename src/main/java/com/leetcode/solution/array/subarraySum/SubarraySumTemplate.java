package com.leetcode.solution.array.subarraySum;

/**
 * https://leetcode.cn/problems/subarray-sum-equals-k/
 * 560. 和为 K 的子数组
 * <p>
 * 给你一个整数数组 nums 和一个整数k ，请你统计并返回 该数组中和为k的连续子数组的个数。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
abstract public class SubarraySumTemplate {
    abstract public int subarraySum(int[] nums, int k);
}
