package com.leetcode.solution.depthFirstSearch.invertBinaryTree.first;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.invertBinaryTree.InvertTreeTemplate;

public class InvertTree extends InvertTreeTemplate {
    @Override
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        helper(root.left);
        helper(root.right);
    }

    @Override
    public TreeNode invertTreeDivideAndConquer(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}
