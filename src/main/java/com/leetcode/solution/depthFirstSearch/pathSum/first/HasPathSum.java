package com.leetcode.solution.depthFirstSearch.pathSum.first;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.pathSum.HasPathSumTemplate;

public class HasPathSum extends HasPathSumTemplate {
    @Override
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            // 叶子节点
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.val;
        }

        int left = root.val + helper(root.left);
        int right = root.val + helper(root.right);

        // 不知道返回哪个值

        return 0;
    }
}
