package com.leetcode.solution.backtracking.binaryTreePaths;

import com.leetcode.solution.binaryTree.TreeNode;

import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-paths/
 * 257. 二叉树的所有路径
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * <p>
 * 示例 2：
 * 输入：root = [1]
 * 输出：["1"]
 */
abstract public class BinaryTreePathsTemplate {
    abstract public List<String> binaryTreePaths(TreeNode root);
}
