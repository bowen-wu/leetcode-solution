package com.leetcode.solution.depthFirstSearch.minimumDepthOfBinaryTree.first;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.minimumDepthOfBinaryTree.MinDepthTemplate;

public class MinDepth extends MinDepthTemplate {
    private int depth;

    @Override
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        depth = Integer.MAX_VALUE;
        helper(root, 1);
        return depth;
    }

    public void helper(TreeNode root, int currentDepth) {
        if (root == null) {
            return;
        }

        // 叶子节点的时候更新
        if (root.left == null && root.right == null && currentDepth < depth) {
            depth = currentDepth;
        }

        helper(root.left, currentDepth + 1);
        helper(root.right, currentDepth + 1);
    }

    @Override
    public int minDepthDivideAndConquer(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
