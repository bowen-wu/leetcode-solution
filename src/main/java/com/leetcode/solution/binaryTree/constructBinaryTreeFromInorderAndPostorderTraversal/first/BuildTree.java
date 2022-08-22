package com.leetcode.solution.binaryTree.constructBinaryTreeFromInorderAndPostorderTraversal.first;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.constructBinaryTreeFromInorderAndPostorderTraversal.BuildTreeTemplate;

import java.util.HashMap;
import java.util.Map;

public class BuildTree extends BuildTreeTemplate {
    @Override
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            cache.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, cache);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> cache) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = cache.get(postorder[postEnd]);


        root.left = helper(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + rootIndex - inStart - 1, cache);
        root.right = helper(inorder, rootIndex + 1, inEnd, postorder, postStart + rootIndex - inStart, postEnd - 1, cache);
        return root;
    }
}
