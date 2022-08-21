package com.leetcode.solution.binaryTree.binaryTreePreorderTraversal;

import com.leetcode.solution.binaryTree.TreeNode;

import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 * 144. 二叉树的前序遍历
 */
abstract public class PreorderTraversalTemplate {
    abstract public List<Integer> preorderTraversal(TreeNode root);

    abstract public List<Integer> preorderTraversalDepth(TreeNode root);

    abstract public List<Integer> preorderTraversalWithRecursion(TreeNode root);
}
