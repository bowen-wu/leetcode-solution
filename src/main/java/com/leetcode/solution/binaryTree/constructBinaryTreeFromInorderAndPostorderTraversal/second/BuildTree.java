package com.leetcode.solution.binaryTree.constructBinaryTreeFromInorderAndPostorderTraversal.second;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.constructBinaryTreeFromInorderAndPostorderTraversal.BuildTreeTemplate;

import java.util.HashMap;
import java.util.Map;

public class BuildTree extends BuildTreeTemplate {
    @Override
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 思路：后续确定根节点，中序分左右 => 中序分左右之后，拿到左右子树个数，之后继续构造
        // 		使用 Map 存储中序 value -> index
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueIndexMap.put(inorder[i], i);
        }

        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, valueIndexMap);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> valueIndexMap) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postEnd]);
        Integer nodeIndex = valueIndexMap.get(postorder[postEnd]);
        if (nodeIndex == null) {
            return null;
        }
        node.left = helper(inorder, inStart, nodeIndex - 1, postorder, postStart, postStart + nodeIndex - inStart - 1, valueIndexMap);
        node.right = helper(inorder, nodeIndex + 1, inEnd, postorder, postStart + nodeIndex - inStart, postEnd - 1, valueIndexMap);
        return node;
    }
}
