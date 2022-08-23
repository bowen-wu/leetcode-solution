package com.leetcode.solution.depthFirstSearch.lowestCommonAncestorOfABinaryTree.first;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.lowestCommonAncestorOfABinaryTree.LowestCommonAncestorTemplate;

public class LowestCommonAncestor extends LowestCommonAncestorTemplate {
    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            // 找到节点
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        // p q 在同一颗树上，返回先遍历到的节点
        return left == null ? right : left;
    }
}
