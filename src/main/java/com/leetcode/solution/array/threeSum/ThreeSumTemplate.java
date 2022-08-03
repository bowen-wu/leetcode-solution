package com.leetcode.solution.array.threeSum;

/**
 * 给定一个包含n个整数的数组（无重复元素）nums和一个目标值target，找出数组中和为目标值的三个数
 * 可以假设每个输入只对应一种答案
 * 例如,
 * 给定数组 nums = [-1, 0, 1, 2, -4]，target = 0
 * 满足要求的三元组集合为： [-1, 0, 1]
 */
abstract public class ThreeSumTemplate {
    public abstract int[] threeSum(int[] nums, int target);
}
