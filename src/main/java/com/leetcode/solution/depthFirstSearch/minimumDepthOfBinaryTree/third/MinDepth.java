package com.leetcode.solution.depthFirstSearch.minimumDepthOfBinaryTree.third;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.minimumDepthOfBinaryTree.MinDepthTemplate;

public class MinDepth extends MinDepthTemplate {
    private int depth;

    @Override
    public int minDepth(TreeNode root) {
        // Ideas: traversal => 1. global variable 2. update global variable when node is leaf and current depth < depth
        if (root == null) {
            return 0;
        }

        depth = Integer.MAX_VALUE;
        helper(root, 1);
        return depth;
    }


    private void helper(TreeNode node, int currentDepth) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            if (currentDepth < depth) {
                depth = currentDepth;
            }
            return;
        }

        helper(node.left, currentDepth + 1);
        helper(node.right, currentDepth + 1);
    }

    @Override
    public int minDepthDivideAndConquer(TreeNode root) {
        // Ideas: divide and conquer =>
        //        分治问题 => 一棵树的最小深度
        // 		  子问题与原问题的关系 => Math.min(子问题 left，子问题 right) + 1
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepthDivideAndConquer(root.left), minDepthDivideAndConquer(root.right)) + 1;
    }
}
