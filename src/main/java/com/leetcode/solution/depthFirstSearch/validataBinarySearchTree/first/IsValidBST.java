package com.leetcode.solution.depthFirstSearch.validataBinarySearchTree.first;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.validataBinarySearchTree.IsValidBSTTemplate;

public class IsValidBST extends IsValidBSTTemplate {
    @Override
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return divideAndConquer(root).isBST;
    }

    private boolean helper(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (min >= root.val || root.val >= max) {
            return false;
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    private Result divideAndConquer(TreeNode root) {
        if (root == null) {
            return new Result(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // Divide
        Result leftNodeResult = divideAndConquer(root.left);
        Result rightNodeResult = divideAndConquer(root.right);

        boolean left = root.left == null || leftNodeResult.max < root.val;
        boolean right = root.right == null || root.val < rightNodeResult.min;

        // Combine
        boolean isBST = leftNodeResult.isBST && rightNodeResult.isBST && left && right;
        return new Result(isBST, Math.min(leftNodeResult.min, root.val), Math.max(rightNodeResult.max, root.val));
    }

    static class Result {
        boolean isBST;
        int min;
        int max;

        public Result(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
}
