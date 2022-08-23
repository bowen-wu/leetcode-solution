package com.leetcode.solution.depthFirstSearch.lowestCommonAncestorOfABinarySearchTree.first;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.lowestCommonAncestorOfABinarySearchTree.LowestCommonAncestorTemplate;

public class LowestCommonAncestor extends LowestCommonAncestorTemplate {
    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q || (p.val < root.val && root.val < q.val) || (q.val < root.val && root.val < p.val)) {
            // p q 在左右子树上
            return root;
        }

        if (p.val < root.val && q.val < root.val) {
            // 都在左子树
            return lowestCommonAncestor(root.left, p, q);
        }
        return lowestCommonAncestor(root.right, p, q);
    }
}
