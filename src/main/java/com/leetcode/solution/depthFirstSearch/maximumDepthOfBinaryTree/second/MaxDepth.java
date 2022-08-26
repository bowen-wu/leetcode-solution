package com.leetcode.solution.depthFirstSearch.maximumDepthOfBinaryTree.second;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.maximumDepthOfBinaryTree.MaxDepthTemplate;

public class MaxDepth extends MaxDepthTemplate {
    @Override
    public int maxDepthDivideAndConquer(TreeNode root) {
        // 思路：分治法 or 遍历法
        if (root == null) {
            return 0;
        }

        int left = maxDepthDivideAndConquer(root.left);
        int right = maxDepthDivideAndConquer(root.right);
        return Math.max(left, right) + 1;
    }

    private int depth;

    @Override
    public int maxDepthTraversal(TreeNode root) {
        // 思路：遍历法
        depth = 0;
        if (root == null) {
            return depth;
        }

        helper(root, 1);
        return depth;
    }

    private void helper(TreeNode root, int currentDepth) {
        if (root == null) {
            return;
        }
        if (currentDepth > depth) {
            depth = currentDepth;
        }
        helper(root.left, currentDepth + 1);
        helper(root.right, currentDepth + 1);
    }
}
