package com.leetcode.solution.depthFirstSearch.lowestCommonAncestorOfABinarySearchTree.second;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.lowestCommonAncestorOfABinarySearchTree.LowestCommonAncestorTemplate;

public class LowestCommonAncestor extends LowestCommonAncestorTemplate {
    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 思路：比较值就可以知道在哪颗子树上
        if (root == null || p == null || q == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        if (p.val < root.val && root.val < q.val || (q.val < root.val && root.val < p.val)) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return lowestCommonAncestor(root.right, p, q);
    }
}
