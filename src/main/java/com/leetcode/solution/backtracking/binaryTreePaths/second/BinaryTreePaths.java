package com.leetcode.solution.backtracking.binaryTreePaths.second;

import com.leetcode.solution.backtracking.binaryTreePaths.BinaryTreePathsTemplate;
import com.leetcode.solution.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths extends BinaryTreePathsTemplate {
    @Override
    public List<String> binaryTreePaths(TreeNode root) {
        // Ideas: backtracking
        // 1. is need sort => no
        // 2. is need element index => no
        // 3. helper => void helper(List<String> result, List<String> list, TreeNode node)
        // 4. when exit recursion => node is leaf
        // 5. when single result add to solution set => node is leaf
        // 6. pruning
        // 7. recusive decomposition sub problem to next level => left + right
        // 8. how to backtracking => single result delete last element
        // solution set
        List<String> result = new ArrayList<>();

        // check input
        if (root == null) {
            return result;
        }

        // single result + calculate solution set
        List<String> list = new ArrayList<>();
        helper(result, list, root);
        return result;
    }

    private void helper(List<String> result, List<String> list, TreeNode node) {
        list.add(String.valueOf(node.val));

        // exit recursion + single result add to solution set
        if (node.left == null && node.right == null) {
            result.add(String.join("->", list));
            return;
        }

        if (node.left != null) {
            helper(result, list, node.left);
            list.remove(list.size() - 1);
        }

        if (node.right != null) {
            helper(result, list, node.right);
            list.remove(list.size() - 1);
        }
    }
}
