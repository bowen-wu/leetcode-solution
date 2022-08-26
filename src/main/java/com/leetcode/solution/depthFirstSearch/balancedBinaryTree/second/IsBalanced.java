package com.leetcode.solution.depthFirstSearch.balancedBinaryTree.second;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.balancedBinaryTree.IsBalancedTemplate;

public class IsBalanced extends IsBalancedTemplate {
    @Override
    public boolean isBalanced(TreeNode root) {
        // 思路：分治法 => 求得左右子树的高度，=> left subTree is balanced & right subTree is balanced & leftHeight rightHeight < 1
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left) + 1;
        int rightHeight = getHeight(root.right) + 1;

        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(leftHeight - rightHeight) <= 1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        return Math.max(left, right) + 1;
    }

    @Override
    public boolean isBalancedTraversal(TreeNode root) {
        // 遍历法 => 从深度开始计算，如果是 -1，就一直返回来
        if (root == null) {
            return true;
        }

        int depth = getDepth(root);
        return depth != -1;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getDepth(node.left);
        int right = getDepth(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
