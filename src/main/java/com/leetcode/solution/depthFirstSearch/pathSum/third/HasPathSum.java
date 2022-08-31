package com.leetcode.solution.depthFirstSearch.pathSum.third;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.pathSum.HasPathSumTemplate;

public class HasPathSum extends HasPathSumTemplate {
    @Override
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Ideas: divide and conquer
        // 		分治问题 => 在树中找和 target 相等的叶子节点
        // 		子问题和原问题关系 => 原问题 = 子问题 left || 子问题 right
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
