package com.leetcode.solution.depthFirstSearch.minimumDepthOfBinaryTree.second;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.minimumDepthOfBinaryTree.MinDepthTemplate;

public class MinDepth extends MinDepthTemplate {
    @Override
    public int minDepthDivideAndConquer(TreeNode root) {
        // 思路：分支法 or 遍历法
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

    private void helper(TreeNode root, int currentDepth) {
        if (root == null) {
            return;
        }

        // 何时更新 depth => 叶子节点的时候更新 depth
        if (root.left == null && root.right == null && currentDepth < depth) {
            depth = currentDepth;
        }

        helper(root.left, currentDepth + 1);
        helper(root.right, currentDepth + 1);
    }
}
