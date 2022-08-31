package com.leetcode.solution.depthFirstSearch.maximumDepthOfBinaryTree.third;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.maximumDepthOfBinaryTree.MaxDepthTemplate;

public class MaxDepth extends MaxDepthTemplate {
    private int depth;

    @Override
    public int maxDepthTraversal(TreeNode root) {
        // Ideas: traversal => 1. global variable 2. update global variable when current depth > global variable
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

    @Override
    public int maxDepthDivideAndConquer(TreeNode root) {
        // Ideas: divide and conquer
        //  	分治的问题 => 一颗树的最大深度
        //      子问题与原问题的关系 => 原问题 = Math.max(子问题 left，子问题 right) + 1
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepthDivideAndConquer(root.left), maxDepthDivideAndConquer(root.right)) + 1;
    }
}
