package com.leetcode.solution.depthFirstSearch.lowestCommonAncestorOfABinaryTree.second;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.lowestCommonAncestorOfABinaryTree.LowestCommonAncestorTemplate;

public class LowestCommonAncestor extends LowestCommonAncestorTemplate {
    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 思路：分治法 => 查看 p q 所在子树
        // 		1. 在两颗子树上，返回 root
        // 		2. 在同一颗子树上，返回改颗子树
        if (root == null || p == null || q == null) {
            return null;
        }

        if (root == p || root == q) {
            // find p or q
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null || right != null) {
            return left != null ? left : right;
        }
        return null;
    }
}
