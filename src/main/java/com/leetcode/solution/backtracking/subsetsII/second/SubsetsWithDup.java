package com.leetcode.solution.backtracking.subsetsII.second;

import com.leetcode.solution.backtracking.subsetsII.SubsetsWithDupTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup extends SubsetsWithDupTemplate {
    @Override
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Ideas: Backtracking => 组合问题
        // 1. 是否需要排序 => 需要 => 解决重复元素问题
        // 2. 是否需要元素位置索引 => 需要
        // 3. helper 函数定义 => private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int position)
        // 4. 递归何时退出 => position >= nums.length
        // 5. 单一解何时加入解集 =>
        // 6. 剪枝 => 去重重复元素 =>
        // 7. 如何递归分解子问题到下一层 => for loop
        // 8. 如何回溯 => 单一解删除最后一个元素
        // 解集
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (nums == null || nums.length == 0) {
            return result;
        }

        // 排序 => 解决重复问题
        Arrays.sort(nums);

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

        // 递归分解子问题到下一层 + 剪枝
        for (int i = position; i < nums.length; i++) {
            if (i > position && nums[i] == nums[i - 1]) {
                // 剪枝
                continue;
            }

            list.add(nums[i]);
            helper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
