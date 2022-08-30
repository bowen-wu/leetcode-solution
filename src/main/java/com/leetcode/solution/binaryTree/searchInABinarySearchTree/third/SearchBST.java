package com.leetcode.solution.binaryTree.searchInABinarySearchTree.third;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.searchInABinarySearchTree.SearchBSTTemplate;

public class SearchBST extends SearchBSTTemplate {
    @Override
    public TreeNode searchBST(TreeNode root, int val) {
        // Ideas: use the BST property, if val > root.val, val must be at root.right, else in root.left
        if (root == null) {
            return null;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.val == val) {
                return node;
            }
            if (node.val > val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }
}
