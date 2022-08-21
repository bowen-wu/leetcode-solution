package com.leetcode.solution.binaryTree.binaryTreeInorderTraversal;

import com.leetcode.solution.binaryTree.TreeNode;

import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * 94. 二叉树的中序遍历
 */
abstract public class InorderTraversalTemplate {
    abstract public List<Integer> inorderTraversal(TreeNode root);

    abstract public List<Integer> inorderTraversalWithRecursion(TreeNode root);
}
