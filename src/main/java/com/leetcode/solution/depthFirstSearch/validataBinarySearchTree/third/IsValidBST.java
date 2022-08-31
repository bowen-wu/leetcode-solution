package com.leetcode.solution.depthFirstSearch.validataBinarySearchTree.third;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.validataBinarySearchTree.IsValidBSTTemplate;

public class IsValidBST extends IsValidBSTTemplate {
    @Override
    public boolean isValidBST(TreeNode root) {
        // Ideas: divide and conquer => min < root.left.val < root.val < root.right.val < max
        // 		分治问题：一棵树是否是 BST
        // 		子问题与原问题关系 => 原问题 = 子问题 left && 子问题 right && leftSubtreeMax < root.val < rightSubTreeMin
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
            if (root.right.val <= root.val || (max != null && root.right.val >= max)) {
                return false;
            }
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
