package com.leetcode.solution.backtracking.combinationSumII;

import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum-ii/
 * 40. 组合总和 II
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次
 * 注意：解集不能包含重复的组合。
 * <p>
 * 示例1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [[1,1,6], [1,2,5], [1,7], [2,6]]
 * <p>
 * 示例2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [[1,2,2], [5]]
 */
abstract public class CombinationSum2Template {
    abstract public List<List<Integer>> combinationSum2(int[] candidates, int target);
}
