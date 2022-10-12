package com.algorithmsAndDataStructures.dynamicProgramming.numberOfLongestIncreasingSubsequence;

/**
 * https://leetcode.cn/problems/number-of-longest-increasing-subsequence/
 * 673. 最长递增子序列的个数
 * 给定一个未排序的整数数组nums，返回最长递增子序列的个数。
 * 注意这个数列必须是 严格 递增的。
 * <p>
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * <p>
 * 示例 2:
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 */
abstract public class FindNumberOfLISTemplate {
    abstract public int findNumberOfLIS(int[] nums);
}
