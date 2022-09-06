package com.leetcode.solution.breadthFirstSearch.binaryTreeZigzagLevelOrderTraversal;

import com.leetcode.solution.breadthFirstSearch.TreeNode;

import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 * 103. 二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * <p>
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 * <p>
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 */
abstract public class ZigzagLevelOrderTemplate {
    abstract public List<List<Integer>> zigzagLevelOrder(TreeNode root);
}
