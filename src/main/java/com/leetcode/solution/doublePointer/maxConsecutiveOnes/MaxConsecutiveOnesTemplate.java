package com.leetcode.solution.doublePointer.maxConsecutiveOnes;

/**
 * https://leetcode.cn/problems/max-consecutive-ones/
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * <p>
 * 示例 2:
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 */
public abstract class MaxConsecutiveOnesTemplate {
    abstract public int findMaxConsecutiveOnes(int[] nums);
}
