package com.leetcode.solution.binaryTree.searchInABinarySearchTree.second;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.searchInABinarySearchTree.SearchBSTTemplate;

public class SearchBST extends SearchBSTTemplate {
    @Override
    public TreeNode searchBST(TreeNode root, int val) {
        // 思路：二分
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
