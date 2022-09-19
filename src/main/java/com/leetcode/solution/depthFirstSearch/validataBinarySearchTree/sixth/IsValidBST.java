package com.leetcode.solution.depthFirstSearch.validataBinarySearchTree.sixth;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.validataBinarySearchTree.IsValidBSTTemplate;

public class IsValidBST extends IsValidBSTTemplate {
    @Override
    public boolean isValidBST(TreeNode root) {
        // Ideas: DFS => min max => min < root.left.val < root.val < root.right.val < max
        // check input
        if (root == null) {
            return true;
        }

        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        // exit recursion
        if (root == null) {
            return true;
        }

        if (root.left != null) {
            if (root.left.val >= root.val || (min != null && min >= root.left.val)) {
                return false;
            }
        }

        if (root.right != null) {
            if (root.right.val <= root.val || (max != null && max <= root.right.val)) {
                return false;
            }
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
