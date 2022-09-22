package com.leetcode.solution.hashTable.containsDuplicate;

/**
 * https://leetcode.cn/problems/contains-duplicate/
 * 217. 存在重复元素
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * <p>
 * 示例3：
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 */
abstract public class ContainsDuplicateTemplate {
    abstract public boolean containsDuplicate(int[] nums);
}
