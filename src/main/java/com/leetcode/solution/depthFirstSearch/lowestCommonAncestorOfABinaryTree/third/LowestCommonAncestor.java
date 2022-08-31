package com.leetcode.solution.depthFirstSearch.lowestCommonAncestorOfABinaryTree.third;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.lowestCommonAncestorOfABinaryTree.LowestCommonAncestorTemplate;

public class LowestCommonAncestor extends LowestCommonAncestorTemplate {
    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Ideas: divide and conquer
        // 		分治问题 => 在树中找 p q 节点
        // 		子问题与原问题关系 =>
        //			子问题 left == null => 原问题 = 子问题 right
        //			子问题 right == null => 原问题 = 子问题 left
        //			原问题 = 子问题 left + 子问题 right
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return null;
    }
}
