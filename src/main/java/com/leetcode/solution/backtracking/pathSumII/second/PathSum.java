package com.leetcode.solution.backtracking.pathSumII.second;

import com.leetcode.solution.backtracking.pathSumII.PathSumTemplate;
import com.leetcode.solution.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum extends PathSumTemplate {
    @Override
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // Ideas: backtracking
        // 1. is need sort => no
        // 2. is need element index => no
        // 3. helper => void helper(List<List<Integer>> result, List<Integer> list, TreeNode root, int target)
        // 4. when exit recursion => node is leaf
        // 5. when single result add to solution set => node is leaf && target == node.val
        // 6. pruning => if node.val > target return
        // 7. recursive decomposition sub problems to next level => left + right
        // 8. how to backtracking => single result delete last element
        // 9. 有负数 => no pruning
        // solution set
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (root == null) {
            return result;
        }

        // single result + calculate solution set
        List<Integer> list = new ArrayList<>();
        helper(result, list, root, targetSum);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, TreeNode node, int target) {
        list.add(node.val);

        // exit recursion + single result add to solution set => deep copy
        if (node.left == null && node.right == null) {
            if (node.val == target) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        // recursive decomposition sub problems to next level + pruning
        if (node.left != null) {
            helper(result, list, node.left, target - node.val);
            list.remove(list.size() - 1);
        }

        if (node.right != null) {
            helper(result, list, node.right, target - node.val);
            list.remove(list.size() - 1);
        }
    }
}
