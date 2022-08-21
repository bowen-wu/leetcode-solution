package com.leetcode.solution.binaryTree.binaryTreePostorderTraversal;

import com.leetcode.solution.binaryTree.TreeNode;

import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/
 * 145. 二叉树的后序遍历
 */
abstract public class PostorderTraversalTemplate {
    abstract public List<Integer> postorderTraversal(TreeNode root);

    abstract public List<Integer> postorderTraversalTwoStack(TreeNode root);

    abstract public List<Integer> postorderTraversalWithRecursion(TreeNode root);
}
