package com.leetcode.solution.backtracking.permutations.second;

import com.leetcode.solution.backtracking.permutations.PermuteTemplate;

import java.util.ArrayList;
import java.util.List;

public class Permute extends PermuteTemplate {
    @Override
    public List<List<Integer>> permute(int[] nums) {
        // Ideas: backtracking => 组合问题
        // 1. 是否需要排序 => 不需要
        // 2. 是否需要元素位置索引 => 不需要
        // 3. helper 函数定义 => void helper(List<List<Integer>> result, List<Integer> list, int[] nums)
        // 4. 递归何时退出 => list.size() == nums.length
        // 5. 单一解何时加入解集 => list.size() == nums.length
        // 6. 剪枝
        // 7. 如何递归分解子问题到下一层 => for loop
        // 8. 如何回溯 => 单一解删除最后一个元素
        // 解集
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (nums == null || nums.length == 0) {
            return result;
        }

        // 单一解 + 计算解集 => 单一解加入解集中
        List<Integer> list = new ArrayList<>();
        helper(result, list, nums);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums) {
        // 递归何时退出 + 单一解何时加入解集 => deep copy
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 递归分解子问题到下一层 + 剪枝
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }

            list.add(nums[i]);
            helper(result, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
