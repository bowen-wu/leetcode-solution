package com.leetcode.solution.backtracking.subsets.first;

import com.leetcode.solution.backtracking.subsets.SubsetsTemplate;

import java.util.ArrayList;
import java.util.List;

public class Subsets extends SubsetsTemplate {
    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
    }

    @Override
    public List<List<Integer>> subsets(int[] nums) {
        // 1. 是否需要对数据源排序 => 不需要
        // 2. 是否需要元素位置索引 => 组合问题需要
        // 3. helper 函数定义 => void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int position)
        // 4. 递归退出条件 => position >= nums.length
        // 5. 单一解加入解集条件 => list 新增元素时
        // 6. 如何剪枝 => 不需要剪枝
        // 7. 如何递归分解子问题到下一层 => for loop
        // 8. 如何回溯 => 去掉单一解中的最后一个元素
        // 解集
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (nums == null) {
            return result;
        }

        // 单一解
        List<Integer> list = new ArrayList<>();

        // sort => 解决重复和大小关系问题

        // 计算解集 => 解集 + 单一解 + 数据源
        result.add(list);
        helper(result, list, nums, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int position) {
        // 1. 递归何时推出
        if (position >= nums.length) {
            return;
        }

        // 3. 递归分解问题，到下一层 => 可能要考虑剪枝
        // 初始值 => 下一层在数组中开始的位置
        for (int i = position; i < nums.length; i++) {
            list.add(nums[i]);

            // 2. 单一解何时加入到解集中 => deep copy
            result.add(new ArrayList<>(list));
            helper(result, list, nums, i + 1);

            // 4. 何时回溯 + 如何回溯 => [1, 2] 回溯到 [1] => 以 [1, 2] 为开头的都已经遍历完，此时移除2
            list.remove(list.size() - 1);
        }
    }
}
