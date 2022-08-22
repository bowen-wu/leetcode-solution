package com.leetcode.solution.binaryTree.deleteNodeInABST.first;

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
                // 删除节点是叶子节点
                return null;
            }
            if (root.left == null) {
                // 删除节点只有右子树
                return root.right;
            }
            if (root.right == null) {
                // 删除节点只有左子树
                return root.left;
            }
            // 删除节点左右子树都有
            // 查找右子树最小值节点
            TreeNode rightMinNode = root.right;
            while (rightMinNode.left != null) {
                rightMinNode = rightMinNode.left;
            }
            root.val = rightMinNode.val;

            // 删除右子树最小值节点
            root.right = deleteNode(root.right, rightMinNode.val);
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
