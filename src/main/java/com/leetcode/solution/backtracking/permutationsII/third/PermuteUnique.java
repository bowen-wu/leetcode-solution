package com.leetcode.solution.backtracking.permutationsII.third;

import com.leetcode.solution.backtracking.permutationsII.PermuteUniqueTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique extends PermuteUniqueTemplate {
    @Override
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Ideas: backtracking => has duplicate element => boolean[] visited
        // solution set
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (nums == null || nums.length == 0) {
            return result;
        }

        // working with source data
        Arrays.sort(nums);

        // single result + calculate solution set => single result add to solution set
        boolean[] visited = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        helper(result, list, nums, visited);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited) {
        // exit recursion + single result add to solution set => deep copy
        if (list.size() >= nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        // recursive decomposition sub problem to next level + pruning => 1. currentValue == prevValue && !visited[prev] 2. list has item
        for (int i = 0; i < nums.length; i++) {
            // pruning
            if (visited[i] || (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1])) {
                continue;
            }

            list.add(nums[i]);
            visited[i] = true;
            helper(result, list, nums, visited);

            // how to backtrack
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}

