package com.leetcode.solution.binaryTree.deleteNodeInABST.third;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.deleteNodeInABST.DeleteNodeTemplate;

public class DeleteNode extends DeleteNodeTemplate {
    @Override
    public TreeNode deleteNode(TreeNode root, int key) {
        // Ideas: find node => delete node
        // 1. is leaf => delete
        // 2. only left => left replace remove node
        // 3. only right => right replace remove node
        // 4. has left and right => left max or right min replace remove node + left or right delete node
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
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
