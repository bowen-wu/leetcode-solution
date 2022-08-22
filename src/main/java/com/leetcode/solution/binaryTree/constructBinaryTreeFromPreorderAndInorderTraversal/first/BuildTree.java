package com.leetcode.solution.binaryTree.constructBinaryTreeFromPreorderAndInorderTraversal.first;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.constructBinaryTreeFromPreorderAndInorderTraversal.BuildTreeTemplate;

import java.util.HashMap;
import java.util.Map;

public class BuildTree extends BuildTreeTemplate {
    @Override
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            cache.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, cache);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> cache) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootPosition = cache.get(preorder[preStart]);

        // 左 ->
        //      preorder [preStart + 1, preStart + 1 + 个数 - 1]
        //      inorder [inStart, i - 1] => 个数: i - 1 - inStart + 1 = i - inStart
        // 右 ->
        //      preorder [preStart + 1 + 个数, preEnd]
        //      inorder [i + 1, inEnd]
        root.left = helper(preorder, preStart + 1, preStart + rootPosition - inStart, inorder, inStart, rootPosition - 1, cache);
        root.right = helper(preorder, preStart + rootPosition - inStart + 1, preEnd, inorder, rootPosition + 1, inEnd, cache);
        return root;
    }
}
