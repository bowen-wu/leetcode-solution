package com.leetcode.solution.backtracking.subsets.third;

import com.leetcode.solution.backtracking.subsets.SubsetsTemplate;

import java.util.ArrayList;
import java.util.List;

public class Subsets extends SubsetsTemplate {
    @Override
    public List<List<Integer>> subsets(int[] nums) {
        // Ideas: backtracking => 组合问题
        // solution set
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (nums == null || nums.length == 0) {
            return result;
        }

        // single result + calculate solution set
        List<Integer> list = new ArrayList<>();
        helper(result, list, nums, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int position) {
        // single result add to solution set => deep copy
        result.add(new ArrayList<>(list));

        // exit recursion
        if (position >= nums.length) {
            return;
        }

        // recursive traversal sub problem to next level + pruning
        for (int i = position; i < nums.length; i++) {
            list.add(nums[i]);
            helper(result, list, nums, i + 1);

            // how to backtracking
            list.remove(list.size() - 1);
        }
    }
}
