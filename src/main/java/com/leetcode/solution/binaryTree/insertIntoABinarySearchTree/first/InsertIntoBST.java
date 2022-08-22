package com.leetcode.solution.binaryTree.insertIntoABinarySearchTree.first;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.insertIntoABinarySearchTree.InsertIntoBSTTemplate;

public class InsertIntoBST extends InsertIntoBSTTemplate {
    @Override
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode node = root;
        while (true) {
            if (node.val == val) {
                return null;
            } else if (node.val > val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return root;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                }
                node = node.right;
            }
        }
    }
}
