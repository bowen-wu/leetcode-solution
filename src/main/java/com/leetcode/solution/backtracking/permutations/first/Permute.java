package com.leetcode.solution.backtracking.permutations.first;

import com.leetcode.solution.backtracking.permutations.PermuteTemplate;

import java.util.ArrayList;
import java.util.List;

public class Permute extends PermuteTemplate {
    @Override
    public List<List<Integer>> permute(int[] nums) {
        // 1. 是否需要对数据源排序 => 不需要，无重复元素
        // 2. 是否需要元素位置索引 => 排列，不需要
        // 3. helper 函数定义 => ` void helper(List<List<Integer>> result, List<Integer> list, int[] nums) `
        // 4. 递归退出条件 => ` list.size() == nums.length `
        // 5. 单一解加入解集条件 => ` list.size() == nums.length `
        // 6. 如何剪枝 => 不需要剪枝
        // 7. 如何递归分解子问题到下一层 => for loop
        // 8. 如何回溯 => 删除单一解的最后一个元素
        // 时间复杂度：O(n!)
        // 解集
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (nums == null || nums.length == 0) {
            return result;
        }

        // 单一解
        List<Integer> list = new ArrayList<>();

        // 是否排序 => 不需要排序
        // 计算解集 => 单一解加入到解集中
        helper(result, list, nums);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums) {
        // 递归退出条件 => list.size() == nums.length
        // 单一解加入解集条件
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 剪枝 => 无
        // 递归分解子问题到下一层
        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            helper(result, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
