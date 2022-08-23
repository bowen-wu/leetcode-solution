package com.leetcode.solution.depthFirstSearch.invertBinaryTree;

import com.leetcode.solution.depthFirstSearch.TreeNode;

/**
 * https://leetcode.cn/problems/invert-binary-tree/
 * 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <p>
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * 示例 2：
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * <p>
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 */
abstract public class InvertTreeTemplate {
    abstract public TreeNode invertTree(TreeNode root);
    abstract public TreeNode invertTreeDivideAndConquer(TreeNode root);
}
