package com.leetcode.solution.depthFirstSearch.pathSum.second;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.pathSum.HasPathSumTemplate;

public class HasPathSum extends HasPathSumTemplate {
    @Override
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 思路：分治法 => find targetSum minus root.val in left and right subtree
        if (root == null) {
            return false;
        }

        if (targetSum == root.val && root.left == null && root.right == null) {
            // leaf && val equals targetSum
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
