package com.leetcode.solution.backtracking.permutationsII.second;

import com.leetcode.solution.backtracking.permutationsII.PermuteUniqueTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique extends PermuteUniqueTemplate {
    @Override
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Ideas: backtracking => 排列问题
        // 1. 是否需要排序 => 需要 => 解决重复问题
        // 2. 是否需要元素位置索引 => 不需要
        // 3. helper 函数定义 => void helper(List<List<Integer>> result, List<Integer> list, int[] nums)
        // 4. 递归何时退出 => list.size() == nums.length
        // 5. 单一解何时加入解集 => list.size() == nums.length
        // 6. 剪枝 => visited[]
        // 7. 如何递归分解子问题到下一层 => for loop
        // 8. 如何回溯 => 单一解删除最后一个元素
        // 解集
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (nums == null || nums.length == 0) {
            return result;
        }

        // Sort => 解决重复问题
        Arrays.sort(nums);

        // i 位置代表当前位置是否被访问过
        boolean[] visited = new boolean[nums.length];

        // 单一解 + 计算解集 => 单一解加入解集中
        List<Integer> list = new ArrayList<>();
        helper(result, list, nums, visited);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited) {
        // 递归何时退出 + 单一解加入解集中 => deep copy
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 递归分解子问题到下一层 + 剪枝
        for (int i = 0; i < nums.length; i++) {
            if ((i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) || visited[i]) {
                // 剪枝
                continue;
            }

            list.add(nums[i]);
            visited[i] = true;
            helper(result, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
