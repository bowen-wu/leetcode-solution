package com.leetcode.solution.depthFirstSearch.maximumDepthOfBinaryTree.first;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.maximumDepthOfBinaryTree.MaxDepthTemplate;

public class MaxDepth extends MaxDepthTemplate {
    @Override
    public int maxDepthDivideAndConquer(TreeNode root) {
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
        depth = 0;

        if (root == null) {
            return depth;
        }

        maxDepthTraversalHelper(root, 1);
        return depth;
    }

    private void maxDepthTraversalHelper(TreeNode root, int currentDepth) {
        if (root == null) {
            return;
        }
        // 当前深度 > depth => 更新 depth
        if (currentDepth > depth) {
            depth = currentDepth;
        }

        maxDepthTraversalHelper(root.left, currentDepth + 1);
        maxDepthTraversalHelper(root.right, currentDepth + 1);
    }
}
