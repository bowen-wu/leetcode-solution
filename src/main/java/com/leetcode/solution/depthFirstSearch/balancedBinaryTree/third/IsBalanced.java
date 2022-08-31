package com.leetcode.solution.depthFirstSearch.balancedBinaryTree.third;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.balancedBinaryTree.IsBalancedTemplate;

public class IsBalanced extends IsBalancedTemplate {
    @Override
    public boolean isBalancedDivideAndConquer(TreeNode root) {
        // Ideas: divide and conquer
        //		分治问题 => 一棵树是否平衡
        //		子问题与原问题关系 => 原问题 = 子问题 left && 子问题 right && Math.abs(leftSubTreeHeight - rightSubTreeHeight) <= 1
        if (root == null) {
            return true;
        }

        int leftSubtreeHeight = getHeightDivideAndConquer(root.left);
        int rightSubtreeHeight = getHeightDivideAndConquer(root.right);

        return isBalancedDivideAndConquer(root.left) && isBalancedDivideAndConquer(root.right) && Math.abs(leftSubtreeHeight - rightSubtreeHeight) <= 1;
    }

    private int getHeightDivideAndConquer(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeightDivideAndConquer(root.left), getHeightDivideAndConquer(root.right)) + 1;
    }

    @Override
    public boolean isBalanced(TreeNode root) {
        // Ideas: tree is balanced when get height
        if (root == null) {
            return true;
        }

        return getHeight(root) != -1;
    }

    // return -1 when tree is not balanced
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight == -1 || rightHeight == -1 || (Math.abs(leftHeight - rightHeight) > 1)) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
