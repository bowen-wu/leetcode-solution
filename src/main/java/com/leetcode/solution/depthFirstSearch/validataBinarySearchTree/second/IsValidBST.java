package com.leetcode.solution.depthFirstSearch.validataBinarySearchTree.second;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.validataBinarySearchTree.IsValidBSTTemplate;

public class IsValidBST extends IsValidBSTTemplate {
    @Override
    public boolean isValidBST(TreeNode root) {
        // 思路：分治法 => left subtree is BST && right subtree is BST && left.val < root.val && root.val < right.val && left subtree max < root.val && root.val < right subtree min
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
            if (root.left.val >= root.val || (min != null && root.left.val <= min)) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.val >= root.right.val || (max != null && root.right.val >= max)) {
                return false;
            }
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
