package com.leetcode.solution.depthFirstSearch.validataBinarySearchTree.fourth;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.validataBinarySearchTree.IsValidBSTTemplate;

public class IsValidBST extends IsValidBSTTemplate {
    @Override
    public boolean isValidBST(TreeNode root) {
        // Ideas: Divide and Conquer => min < root.left.val < root.val < root.right.val < max
        if (root == null) {
            return true;
        }

        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (root.left != null) {
            if ((min != null && root.left.val <= min) || (root.val <= root.left.val)) {
                return false;
            }
        }
        if (root.right != null) {
            if ((max != null && root.right.val >= max) || (root.val >= root.right.val)) {
                return false;
            }
        }

        // divide
        boolean left = helper(root.left, min, root.val);
        boolean right = helper(root.right, root.val, max);

        // combine
        return left && right;
    }
}
