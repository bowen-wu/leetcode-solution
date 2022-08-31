package com.leetcode.solution.depthFirstSearch.symmetricTree.third;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.symmetricTree.IsSymmetricTemplate;

public class IsSymmetric extends IsSymmetricTemplate {
    @Override
    public boolean isSymmetric(TreeNode root) {
        // Ideas: i think this is divide and conquer
        if (root == null) {
            return true;
        }
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSame(left.left, right.right) && isSame(left.right, right.left);
    }
}
