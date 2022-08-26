package com.leetcode.solution.depthFirstSearch.invertBinaryTree.second;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.invertBinaryTree.InvertTreeTemplate;

public class InvertTree extends InvertTreeTemplate {
    @Override
    public TreeNode invertTreeDivideAndConquer(TreeNode root) {
        // 思路：分治法 or 遍历法
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }

    @Override
    public TreeNode invertTree(TreeNode root) {
        // 思路：遍历法
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
}
