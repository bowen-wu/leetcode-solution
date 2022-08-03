package com.leetcode.solution.array.twoSum;

/**
 * 给定一个整数数组（无重复元素）和一个目标值，找出数组中和为目标值的两个数。
 * 按照从小到大的顺序输出结果对
 * 可以假设每个输入只对应一种答案
 * Input: numbers = {2, 7, 11, 15}, target = 9
 * Output: {2, 7}
 */

public abstract class TwoSumTemplate {
    public abstract int[] twoSum(int[] nums, int target);
}
