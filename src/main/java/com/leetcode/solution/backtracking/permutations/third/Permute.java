package com.leetcode.solution.backtracking.permutations.third;

import com.leetcode.solution.backtracking.permutations.PermuteTemplate;

import java.util.ArrayList;
import java.util.List;

public class Permute extends PermuteTemplate {
    @Override
    public List<List<Integer>> permute(int[] nums) {
        // Ideas: backtracking => 排列问题
        // solution set
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (nums == null || nums.length == 0) {
            return result;
        }

        // working with source data
        // single result + calculate solution set => single result add to solution set
        List<Integer> list = new ArrayList<>();
        helper(result, list, nums);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums) {
        // exit recursion + single result add to solution set => deep copy
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        // recursive decomposition sub problem to next level + pruning
        for (int i = 0; i < nums.length; i++) {
            // pruning
            if (list.contains(nums[i])) {
                continue;
            }

            list.add(nums[i]);
            helper(result, list, nums);

            // how to backtrack
            list.remove(list.size() - 1);
        }
    }
}
