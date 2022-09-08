package com.leetcode.solution.backtracking.pathSumII.third;

import com.leetcode.solution.backtracking.pathSumII.PathSumTemplate;
import com.leetcode.solution.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum extends PathSumTemplate {
    @Override
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // Ideas: backtracking
        // is need working with resource data => no
        // is need element position index => no
        // helper => void helper(List<List<Integer>> result, List<Integer> list, TreeNode root, int targetSum)
        // when exit recursion => root is leaf
        // when single result add to solution set => root is leaf && targetSum == root.val
        // pruning => root.val > targetSum x => root.val may be < 0 => no pruning
        // recursive decomposition sub problem to next level => left + right
        // how to backtrack => single result delete last element
        // solution set
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (root == null) {
            return result;
        }

        // single result + calculate solution set => single result add to solution set
        List<Integer> list = new ArrayList<>();
        helper(result, list, root, targetSum);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, TreeNode root, int targetSum) {
        list.add(root.val);

        // exit recursion + single result add to solution set => deep copy
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        // recursive decomposition sub problem to next level
        if (root.left != null) {
            helper(result, list, root.left, targetSum - root.val);
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            helper(result, list, root.right, targetSum - root.val);
            list.remove(list.size() - 1);
        }
    }
}
