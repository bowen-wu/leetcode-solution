package com.leetcode.solution.binaryTree.deleteNodeInABST.fourth;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.deleteNodeInABST.DeleteNodeTemplate;

public class DeleteNode extends DeleteNodeTemplate {
    @Override
    public TreeNode deleteNode(TreeNode root, int key) {
        // Ideas: traversal delete => delete node
        // 1. is leaf => null
        // 2. only has one subtree => subtree replace delete node
        // 3. has left and right subtree => find max or min in left or right subtree replace delete node, and delete max or min node
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if (root.left == null && root.right == null) {
                // leaf
                return null;
            }

            if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            }

            TreeNode leftMaxNode = root.left;
            while (leftMaxNode.right != null) {
                leftMaxNode = leftMaxNode.right;
            }
            root.val = leftMaxNode.val;
            root.left = deleteNode(root.left, leftMaxNode.val);
            return root;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }
}
