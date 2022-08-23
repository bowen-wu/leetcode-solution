package com.leetcode.solution.depthFirstSearch.symmetricTree;

import com.leetcode.solution.depthFirstSearch.TreeNode;

/**
 * https://leetcode.cn/problems/symmetric-tree/
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
abstract public class IsSymmetricTemplate {
    abstract public boolean isSymmetric(TreeNode root);
}
