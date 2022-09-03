package com.leetcode.solution.backtracking.combinationSum.second;

import com.leetcode.solution.backtracking.combinationSum.CombinationSumTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum extends CombinationSumTemplate {
    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Ideas: backtracking => 组合问题
        // 1. 是否需要排序 => 需要
        // 2. 是否需要元素位置索引 => 需要
        // 3. helper 函数定义 => helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int position)
        // 4. 递归何时退出 => target < 0
        // 5. 单一解加入解集中 => target == 0 => target 在递归的过程中逐步递减
        // 6. 剪枝
        // 7. 递归分解子问题到下一层 => for loop
        // 8. 如何回溯 => 单一解删除最后一个元素
        // 解集
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return result;
        }

        // Sort => 解决大小问题
        Arrays.sort(candidates);

        // 单一解 + 计算解集 => 单一解加入解集中
        List<Integer> list = new ArrayList<>();
        helper(result, list, candidates, target, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int position) {
        // 递归何时退出 + 单一解加入解集中 => deep copy
        if (target <= 0) {
            if (target == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        // 递归分解子问题到下一层 + 剪枝
        for (int i = position; i < candidates.length; i++) {
            if (target < candidates[i]) {
                // 剪枝
                break;
            }

            list.add(candidates[i]);
            helper(result, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}
