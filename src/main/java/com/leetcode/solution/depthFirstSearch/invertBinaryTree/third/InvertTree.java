package com.leetcode.solution.depthFirstSearch.invertBinaryTree.third;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.invertBinaryTree.InvertTreeTemplate;

public class InvertTree extends InvertTreeTemplate {
    @Override
    public TreeNode invertTree(TreeNode root) {
        // Ideas: traversal
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

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        helper(root.left);
        helper(root.right);
    }


    @Override
    public TreeNode invertTreeDivideAndConquer(TreeNode root) {
        // Ideas: divide and conquer
        // 		分治问题 => 翻转一棵树
        //  	子问题和原问题关系 => 原问题 = 子问题 left + 子问题 right + 一次翻转
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
