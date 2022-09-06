package com.leetcode.solution.breadthFirstSearch.binaryTreeLevelOrderTraversal;

import com.leetcode.solution.breadthFirstSearch.TreeNode;

import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 * 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * <p>
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 * <p>
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 */
abstract public class LevelOrderTemplate {
    abstract public List<List<Integer>> levelOrder(TreeNode root);
}
