package com.leetcode.solution.backtracking.subsetsII;

import java.util.List;

/**
 * https://leetcode.cn/problems/subsets-ii/
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
abstract public class SubsetsWithDupTemplate {
    abstract public List<List<Integer>> subsetsWithDup(int[] nums);
}
