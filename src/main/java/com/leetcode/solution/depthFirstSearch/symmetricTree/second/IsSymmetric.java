package com.leetcode.solution.depthFirstSearch.symmetricTree.second;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.symmetricTree.IsSymmetricTemplate;

public class IsSymmetric extends IsSymmetricTemplate {
    @Override
    public boolean isSymmetric(TreeNode root) {
        // 思路：分治法 => 轴对称 => 左与右对称，继续深入比较
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
