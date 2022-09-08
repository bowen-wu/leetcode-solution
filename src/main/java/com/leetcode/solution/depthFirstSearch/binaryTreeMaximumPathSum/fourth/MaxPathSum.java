package com.leetcode.solution.depthFirstSearch.binaryTreeMaximumPathSum.fourth;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.binaryTreeMaximumPathSum.MaxPathSumTemplate;

public class MaxPathSum extends MaxPathSumTemplate {
    private int pathSum = Integer.MIN_VALUE;

    @Override
    public int maxPathSum(TreeNode root) {
        // Ideas: Divide and Conquer => for every node:
        // 1. node.val
        // 2. node.left.val
        // 3. node.right.val
        // 4. node.left.val + node.val + node.right.val
        // 5. node.left.val + node.val
        // 6. node.right.val + node.val
        if (root == null) {
            return 0;
        }

        return Math.max(helper(root), pathSum);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        // divide
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        // left + root + right
        pathSum = Math.max(pathSum, left + root.val + right);

        // left vs right vs left + root vs right + root vs root
        return Math.max(Math.max(left, right) + root.val, root.val);
    }
}
