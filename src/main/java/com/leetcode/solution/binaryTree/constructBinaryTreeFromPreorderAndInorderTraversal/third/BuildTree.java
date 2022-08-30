package com.leetcode.solution.binaryTree.constructBinaryTreeFromPreorderAndInorderTraversal.third;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.constructBinaryTreeFromInorderAndPostorderTraversal.BuildTreeTemplate;

import java.util.HashMap;
import java.util.Map;

public class BuildTree extends BuildTreeTemplate {
    @Override
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 思路：preorder confirm root, inorder can split left right
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> valueToIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueToIndexMap.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valueToIndexMap);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> valueToIndexMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        Integer rootIndex = valueToIndexMap.get(preorder[preStart]);
        if (rootIndex == null) {
            return null;
        }
        root.left = helper(preorder, preStart + 1, preStart + rootIndex - inStart, inorder, inStart, rootIndex - 1, valueToIndexMap);
        root.right = helper(preorder, preStart + rootIndex - inStart + 1, preEnd, inorder, rootIndex + 1, inEnd, valueToIndexMap);
        return root;
    }
}
