package com.leetcode.solution.backtracking.combinationSum.first;

import com.leetcode.solution.backtracking.combinationSum.CombinationSumTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum extends CombinationSumTemplate {
    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 1. 是否需要对数据源排序 => 需要
        // 2. 是否需要元素位置索引 => 组合问题，需要
        // 3. helper 函数定义 => ` void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int position, int target) `
        // 4. 递归退出条件 => position >= nums.length
        // 5. 单一解加入解集条件 => ` listSum == target `
        // 6. 剪枝 => 如果当前 list 的和大于 target，不需要继续向下了
        // 7. 如何递归分解子问题到下一层 => for loop
        // 8. 如何回溯 => 删除单一解的最后一个元素
        // 解集
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        // 单一解 + 排序
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);

        // 计算解集 => 单一解如何加入到解集中
        helper(result, list, candidates, 0, target);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int position, int target) {
        // 单一解加入解集 => Deep Copy
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 递归退出条件 + 剪枝
        if (position >= candidates.length || target < 0) {
            return;
        }

        // 递归分解子问题到下一层
        for (int i = position; i < candidates.length; i++) {
            // 剪枝
            if (candidates[i] > target) {
                return;
            }
            list.add(candidates[i]);

            // 同一个数字可以无限重复被选取，所以下一层依然从 i 开始
            helper(result, list, candidates, i, target - candidates[i]);

            // 如何回溯
            list.remove(list.size() - 1);
        }
    }
}
