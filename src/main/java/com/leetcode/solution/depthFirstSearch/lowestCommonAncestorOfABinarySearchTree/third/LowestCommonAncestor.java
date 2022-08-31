package com.leetcode.solution.depthFirstSearch.lowestCommonAncestorOfABinarySearchTree.third;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.lowestCommonAncestorOfABinarySearchTree.LowestCommonAncestorTemplate;

public class LowestCommonAncestor extends LowestCommonAncestorTemplate {
    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Ideas: divide and conquer
        //		分治问题 => 在树中找 p q 节点
        if (root == null || p == null || q == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
