package com.leetcode.solution.depthFirstSearch.symmetricTree.first;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.symmetricTree.IsSymmetricTemplate;

public class IsSymmetric extends IsSymmetricTemplate {
    private boolean symmetric;

    @Override
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        symmetric = true;
        helper(root.left, root.right);
        return symmetric;
    }

    private void helper(TreeNode left, TreeNode right) {
        // 何时更新 =>
        if ((left != null && right == null) || (left == null && right != null) || (left != null && left.val != right.val)) {
            symmetric = false;
        } else {
            if (left == null) {
                return;
            }
            helper(left.right, right.left);
            helper(left.left, right.right);
        }
    }

    private boolean helperWithReturn(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return helperWithReturn(left.right, right.left) && helperWithReturn(left.left, right.right);
    }
}
