package com.leetcode.solution.sort.reversePairs;

/**
 * https://leetcode.cn/problems/reverse-pairs/
 * 493. 翻转对
 * 给定一个数组nums，如果i < j且nums[i] > 2*nums[j]我们就将(i, j)称作一个重要翻转对。
 * 你需要返回给定数组中的重要翻转对的数量。
 * <p>
 * 示例 1:
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [2,4,3,5,1]
 * 输出: 3
 */
abstract public class ReversePairsTemplate {
    abstract public int reversePairs(int[] nums);
}
