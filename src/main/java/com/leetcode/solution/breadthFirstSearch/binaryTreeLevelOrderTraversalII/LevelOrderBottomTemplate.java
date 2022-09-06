package com.leetcode.solution.breadthFirstSearch.binaryTreeLevelOrderTraversalII;

import com.leetcode.solution.breadthFirstSearch.TreeNode;

import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
 * 107. 二叉树的层序遍历 II
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[15,7],[9,20],[3]]
 * <p>
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 * <p>
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 */
abstract public class LevelOrderBottomTemplate {
    abstract public List<List<Integer>> levelOrderBottom(TreeNode root);
}
