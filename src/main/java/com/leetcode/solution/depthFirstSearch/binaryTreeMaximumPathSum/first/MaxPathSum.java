package com.leetcode.solution.depthFirstSearch.binaryTreeMaximumPathSum.first;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.binaryTreeMaximumPathSum.MaxPathSumTemplate;

public class MaxPathSum extends MaxPathSumTemplate {
    private int maxPath = Integer.MIN_VALUE;

    @Override
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        divideAndConquer(root);
        return maxPath;
    }

    private int divideAndConquer(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left = Math.max(divideAndConquer(root.left), 0);
        int right = Math.max(divideAndConquer(root.right), 0);
        int rootValue = root.val;
        int currentMaxPath = Math.max(Math.max(rootValue + right, rootValue + left), rootValue);

        // 更新全局变量 maxPath
        maxPath = Math.max(Math.max(left + right + rootValue, currentMaxPath), maxPath);
        return currentMaxPath;
    }
}
