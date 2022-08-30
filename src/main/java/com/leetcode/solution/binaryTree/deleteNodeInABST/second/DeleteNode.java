package com.leetcode.solution.binaryTree.deleteNodeInABST.second;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.deleteNodeInABST.DeleteNodeTemplate;

public class DeleteNode extends DeleteNodeTemplate {
    @Override
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode minValueInRight = root.right;
            while (minValueInRight.left != null) {
                minValueInRight = minValueInRight.left;
            }
            root.val = minValueInRight.val;
            root.right = deleteNode(root.right, minValueInRight.val);
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public TreeNode deleteNodeWithTraversal(TreeNode root, int key) {
        // Ideas: First need to find node with value is equals key,
        // 		  delete node is leaf => delete
        // 		  delete node only has left subtree or right subtree => subtree replace delete node
        //        second find max value in left subtree or min value in right subtree
        // 		  change node value to max value or min value
        // 		  delete node with max value in left subtree or node with min value in right subtree
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null || root.right == null) {
                return root.right == null ? root.left : root.right;
            }
        }
        TreeNode parent = null;
        TreeNode node = root;
        while (node != null) {
            if (node.val == key) {
                // delete node;
                if (node.left != null && node.right != null) {
                    TreeNode minValueNodeInRight = node.right;
                    while (minValueNodeInRight.left != null) {
                        minValueNodeInRight = minValueNodeInRight.left;
                    }
                    node.val = minValueNodeInRight.val;
                    node.right = deleteNode(node.right, minValueNodeInRight.val);
                    return root.val == key ? node : root;
                }
                TreeNode temp = (node.left == null && node.right == null) ? null : (node.right == null ? node.left : node.right);
                if (parent.left == node) {
                    parent.left = temp;
                } else {
                    parent.right = temp;
                }
                return root;
            }
            parent = node;
            if (node.val > key) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return root;
    }
}
