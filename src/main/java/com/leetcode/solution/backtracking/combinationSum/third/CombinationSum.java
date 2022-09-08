package com.leetcode.solution.backtracking.combinationSum.third;

import com.leetcode.solution.backtracking.combinationSum.CombinationSumTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum extends CombinationSumTemplate {
    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Ideas: backtracking => 组合问题
        // solution set
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        // working with source data
        Arrays.sort(candidates);

        // single result + calculate solution set => single result add to solution set
        List<Integer> list = new ArrayList<>();
        helper(result, list, candidates, 0, target);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int position, int target) {
        // single result add to solution set => deep copy
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        // when exit recursion
        if (position >= candidates.length) {
            return;
        }

        // recursive decomposition sub problem to next level + pruning
        for (int i = position; i < candidates.length; i++) {
            // pruning
            if (candidates[i] > target) {
                break;
            }

            list.add(candidates[i]);
            helper(result, list, candidates, i, target - candidates[i]);

            // how to backtrack
            list.remove(list.size() - 1);
        }
    }
}
