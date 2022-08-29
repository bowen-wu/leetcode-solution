package com.leetcode.solution.backtracking.subsetsII.first;

import com.leetcode.solution.backtracking.subsetsII.SubsetsWithDupTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup extends SubsetsWithDupTemplate {
    @Override
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 1. 是否需要对数据源排序 => 需要
        // 2. 是否需要元素位置索引 => 组合问题，需要
        // 3. helper 函数定义 => `void helper (List < List < Integer >> result, List < Integer > list,int[] nums, int position) `
        // 4. 递归退出条件 => position >= nums.length
        // 5. 单一解加入解集条件 => 无条件
        // 6. 如何剪枝 => 如果当前元素和前一个元素相等，直接跳过
        // 7. 如何递归分解子问题到下一层 => for loop
        // 8. 如何回溯 => 去掉单一解的最后一个元素
        // 解集
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (nums == null || nums.length == 0) {
            return result;
        }

        // 单一解
        List<Integer> list = new ArrayList<>();

        // 排序
        Arrays.sort(nums);

        // 计算解集 => 将单一解加入到解集中
        helper(result, list, nums, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int position) {
        result.add(new ArrayList<>(list));

        // 递归退出条件
        if (position >= nums.length) {
            return;
        }

        // 递归分解子问题到下一层
        for (int i = position; i < nums.length; i++) {
            // 剪枝
            if (i > position && nums[i - 1] == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            helper(result, list, nums, i + 1);

            // 如何回溯
            list.remove(list.size() - 1);
        }
    }
}
