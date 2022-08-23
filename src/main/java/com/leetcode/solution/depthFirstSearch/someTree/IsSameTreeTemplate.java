package com.leetcode.solution.depthFirstSearch.someTree;

import com.leetcode.solution.depthFirstSearch.TreeNode;

/**
 * https://leetcode.cn/problems/same-tree/
 * 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1：
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 */
abstract public class IsSameTreeTemplate {
    abstract public boolean isSameTree(TreeNode p, TreeNode q);
}
