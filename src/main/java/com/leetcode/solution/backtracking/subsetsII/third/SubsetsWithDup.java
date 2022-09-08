package com.leetcode.solution.backtracking.subsetsII.third;

import com.leetcode.solution.backtracking.subsetsII.SubsetsWithDupTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup extends SubsetsWithDupTemplate {
    @Override
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Ideas: backtracking => has duplicated element
        // solution set
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (nums == null || nums.length == 0) {
            return result;
        }

        // working with source data
        Arrays.sort(nums);

        // single result + calculate solution set => single result add to solution set
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

        // recursive decomposition sub problem to next level + pruning
        for (int i = position; i < nums.length; i++) {
            // pruning
            if (i > position && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            helper(result, list, nums, i + 1);

            // how to backtrack
            list.remove(list.size() - 1);
        }
    }
}
