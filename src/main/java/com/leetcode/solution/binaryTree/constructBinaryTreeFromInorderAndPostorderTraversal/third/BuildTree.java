package com.leetcode.solution.binaryTree.constructBinaryTreeFromInorderAndPostorderTraversal.third;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.constructBinaryTreeFromInorderAndPostorderTraversal.BuildTreeTemplate;

import java.util.HashMap;
import java.util.Map;

public class BuildTree extends BuildTreeTemplate {
    @Override
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Ideas: postorder last is root value, inorder can split left and right via root value
        // 		  use Map cache value and index in inorder array
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> valueToIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueToIndexMap.put(inorder[i], i);
        }

        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, valueToIndexMap);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> valueToIndexMap) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        Integer rootIndex = valueToIndexMap.get(postorder[postEnd]);
        if (rootIndex == null) {
            return null;
        }
        root.left = helper(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + rootIndex - 1 - inStart, valueToIndexMap);
        root.right = helper(inorder, rootIndex + 1, inEnd, postorder, postStart + rootIndex - inStart, postEnd - 1, valueToIndexMap);
        return root;
    }
}
