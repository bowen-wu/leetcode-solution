package com.leetcode.solution.binaryTree.constructBinaryTreeFromInorderAndPostorderTraversal;

import com.leetcode.solution.binaryTree.TreeNode;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 106. 从中序与后序遍历序列构造二叉树
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 * <p>
 * 示例 1:
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * <p>
 * 示例 2:
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 */
abstract public class BuildTreeTemplate {
    abstract public TreeNode buildTree(int[] inorder, int[] postorder);
}
