package com.leetcode.solution.backtracking.subsets.second;

import com.leetcode.solution.backtracking.subsets.SubsetsTemplate;

import java.util.ArrayList;
import java.util.List;

public class Subsets extends SubsetsTemplate {
    @Override
    public List<List<Integer>> subsets(int[] nums) {
        // 思路：回溯 + 组合问题
        // 1. 是否需要排序 => 不需要
        // 2. 是否需要元素位置索引 => 需要
        // 3. helper 函数定义 => void helper(List<List<Integer>> result, List<Integer> list, int nums, int position);
        // 4. 递归何时退出 => position >= nums.length
        // 5. 单一解何时加入解集 => 无限制
        // 6. 剪枝
        // 7. 如何遍历子问题到下一层 => for loop
        // 8. 如何回溯 => 单一解删除最后一个元素
        // 解集
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (nums == null || nums.length == 0) {
            return result;
        }

        // 单一解 + 计算解集 => 单一解加入解集中
        List<Integer> list = new ArrayList<>();
        helper(result, list, nums, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int position) {
        // 单一解何时加入解集 => deep copy
        result.add(new ArrayList<>(list));

        // 递归何时退出
        if (position >= nums.length) {
            return;
        }

        // 递归遍历子问题到下一层 + 剪枝
        for (int i = position; i < nums.length; i++) {
            list.add(nums[i]);
            helper(result, list, nums, i + 1);

            // 如何回溯
            list.remove(list.size() - 1);
        }
    }
}
