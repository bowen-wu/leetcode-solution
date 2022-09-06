package com.leetcode.solution.depthFirstSearch.binaryTreeMaximumPathSum.third;


import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.binaryTreeMaximumPathSum.MaxPathSumTemplate;

public class MaxPathSum extends MaxPathSumTemplate {
    private int maxPath = Integer.MIN_VALUE;

    @Override
    public int maxPathSum(TreeNode root) {
        // Ideas: dfs => for everyone node
        // 1. node
        // 2. left
        // 3. right
        // 4. left + node + right
        // 5. node + left
        // 6. node + right
        if (root == null) {
            return 0;
        }

        return Math.max(maxPath, helper(root));
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        // left + node + right
        maxPath = Math.max(maxPath, left + root.val + right);

        // left vs right vs node + left vs node + right vs node
        return Math.max(Math.max(left, right) + root.val, root.val);
    }
}
