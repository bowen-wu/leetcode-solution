package com.leetcode.solution.depthFirstSearch.balancedBinaryTree.first;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.balancedBinaryTree.IsBalancedTemplate;

public class IsBalanced extends IsBalancedTemplate {
    @Override
    public boolean isBalancedTraversal(TreeNode root) {
        // 时间复杂度：O(n)
        return getHeightBottomUp(root) != -1;
    }

    private int getHeightBottomUp(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeightBottomUp(root.left);
        int rightHeight = getHeightBottomUp(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public boolean isBalanced(TreeNode root) {
        // 时间复杂度：O(n * logn)
        if (root == null) {
            return true;
        }

        // 时间复杂度和深度有关
        if (Math.abs(getHeightTopDown(root.left) - getHeightTopDown(root.right)) > 1) {
            return false;
        }

        // Divide
        boolean leftIsBalanced = isBalanced(root.left);
        boolean rightIsBalanced = isBalanced(root.right);

        // Combine
        return leftIsBalanced && rightIsBalanced;
    }

    private int getHeightTopDown(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeightTopDown(root.left), getHeightTopDown(root.right)) + 1;
    }
}
