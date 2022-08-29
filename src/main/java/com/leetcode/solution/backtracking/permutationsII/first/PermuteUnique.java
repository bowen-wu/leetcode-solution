package com.leetcode.solution.backtracking.permutationsII.first;

import com.leetcode.solution.backtracking.permutations.PermuteTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique extends PermuteTemplate {
    public static void main(String[] args) {
        System.out.println(new PermuteUnique().permute(new int[]{1, 1, 2}));
    }

    @Override
    public List<List<Integer>> permute(int[] nums) {
        // 1. 是否需要对数据源排序 => 需要
        // 2. 是否需要元素位置索引 => 不需要
        // 3. helper 函数定义 => ` void helper(List<List<Integer>> result, List<Integer> list, int[] nums) `
        // 4. 递归退出条件 => ` list.size() == nums.length `
        // 5. 单一解加入解集条件 => ` list.size() == nums.length `
        // 6. 如何剪枝 =>
        // 7. 如何分解子问题到下一层 => for loop
        // 8. 如何回溯 => 删除单一解的最后一个元素
        // 解集
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (nums == null || nums.length == 0) {
            return result;
        }

        // 单一解 + 排序
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);

        // 计算解集 => 将单一解加入解集中
        helper(result, list, nums, visited);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited) {
        // 递归退出条件 or 单一解加入解集
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 递归分解子问题到下一层
        for (int i = 0; i < nums.length; i++) {
            // 剪枝 => [1, 1, 1]
            if (visited[i]) {
                continue;
            }

            // 剪枝2 => [1(1), 1(2), 2] [1(2), 1(1), 2]
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            list.add(nums[i]);
            helper(result, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
