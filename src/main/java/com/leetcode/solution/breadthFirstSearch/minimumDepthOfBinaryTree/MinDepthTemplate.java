package com.leetcode.solution.breadthFirstSearch.minimumDepthOfBinaryTree;

import com.leetcode.solution.breadthFirstSearch.TreeNode;

/**
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 */
abstract public class MinDepthTemplate {
    abstract public int minDepth(TreeNode root);
}
