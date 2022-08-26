package com.leetcode.solution.binaryTree.constructBinaryTreeFromPreorderAndInorderTraversal.second;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.constructBinaryTreeFromPreorderAndInorderTraversal.BuildTreeTemplate;

import java.util.HashMap;
import java.util.Map;

public class BuildTree extends BuildTreeTemplate {
    @Override
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 思路：前序+中序构造二叉树 => 前序确定根节点，中序分左右 => 之后在前序中递归的构造树
        // 		获取根节点在中序的位置，之后根据个数，可以拿到前序中左右子树的分界
        // 		利用 map 可以在 O(1) 的时间内找到根节点在中序的位置
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueIndexMap.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valueIndexMap);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> valueIndexMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootValue = preorder[preStart];
        Integer rootIndex = valueIndexMap.get(rootValue);
        if (rootIndex == null) {
            return null;
        }
        TreeNode node = new TreeNode(rootValue);
        node.left = helper(preorder, preStart + 1, preStart + rootIndex - inStart, inorder, inStart, rootIndex - 1, valueIndexMap);
        node.right = helper(preorder, preStart + rootIndex - inStart + 1, preEnd, inorder, rootIndex + 1, inEnd, valueIndexMap);
        return node;
    }
}
