package com.leetcode.solution.depthFirstSearch.binaryTreeMaximumPathSum.second;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.binaryTreeMaximumPathSum.MaxPathSumTemplate;

public class MaxPathSum extends MaxPathSumTemplate {
    private int pathSum = Integer.MIN_VALUE;

    @Override
    public int maxPathSum(TreeNode root) {
        // Ideas: 对于每一个节点 root：
        //			1. 只选择 root
        //			2. 选择 root.left
        //			3. 选择 root.right
        //			4. 选择 root + root.left
        //			5. 选择 root + root.right
        //			6. 选择 root.left + root + root.right
        if (root == null) {
            return 0;
        }

        return Math.max(helper(root), pathSum);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        if (left + root.val + right > pathSum) {
            pathSum = left + root.val + right;
        }

        return Math.max(Math.max(left + root.val, right + root.val), root.val);
    }
}
