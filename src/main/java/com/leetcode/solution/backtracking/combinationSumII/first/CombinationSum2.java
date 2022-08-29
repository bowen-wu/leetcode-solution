package com.leetcode.solution.backtracking.combinationSumII.first;

import com.leetcode.solution.backtracking.combinationSumII.CombinationSum2Template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 extends CombinationSum2Template {
    @Override
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 1. 是否需要排序 => 需要
        // 2. 是否需要元素位置索引 => 需要
        // 3. helper 函数定义 => ` void helper(List<List<Integer> result, List<Integer> list, int[] nums, int position, int target) `
        // 4. 递归退出条件 => position >= nums.length
        // 5. 单一解何时加入解集 => target == 0
        // 6. 剪枝 => target < 0 + nums[i] > target
        // 7. 如何分解子问题到下一层 => for loop
        // 8. 如何回溯 => 单一解移除最后一个元素
        // 9. 优化 => target 逐步递减，便可以不用计算 list 的 sum
        // 解集
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        // 单一解 + 排序
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);

        // 计算解集 => 将单一解加入到解集中
        helper(result, list, candidates, 0, target);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int position, int target) {
        // 单一解加入到解集中
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 递归退出条件
        if (position >= candidates.length) {
            return;
        }

        // 递归分解子问题进入下一层
        for (int i = position; i < candidates.length; i++) {
            // 剪枝
            if (candidates[i] > target) {
                return;
            }

            // 剪枝
            if (i > position && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            helper(result, list, candidates, i + 1, target - candidates[i]);

            // 如何回溯
            list.remove(list.size() - 1);
        }
    }
}
