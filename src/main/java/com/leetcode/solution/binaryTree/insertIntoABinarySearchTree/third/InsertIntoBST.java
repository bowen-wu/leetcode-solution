package com.leetcode.solution.binaryTree.insertIntoABinarySearchTree.third;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.insertIntoABinarySearchTree.InsertIntoBSTTemplate;

public class InsertIntoBST extends InsertIntoBSTTemplate {
    @Override
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // Ideas: use the BST property, create node pointer, first the pointer points to root,
        // 		  if val > node.val, the pointer points to node.right else the pointer points to node.left
        // 		  inserts when node.left or node.right is null
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode node = root;
        while (true) {
            if (node.val == val) {
                return root;
            }
            if (node.val > val) {
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
