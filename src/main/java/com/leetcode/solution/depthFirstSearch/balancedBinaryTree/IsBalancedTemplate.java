package com.leetcode.solution.depthFirstSearch.balancedBinaryTree;

import com.leetcode.solution.depthFirstSearch.TreeNode;

/**
 * https://leetcode.cn/problems/balanced-binary-tree/
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：root = []
 * 输出：true
 */
abstract public class IsBalancedTemplate {
    abstract public boolean isBalancedTraversal(TreeNode root);

    abstract public boolean isBalanced(TreeNode root);
}
