package com.leetcode.solution;

import static com.leetcode.solution.Codec.getTreeNode;

/**
 * https://leetcode.cn/problems/delete-node-in-a-bst/
 * 450. 删除二叉搜索树中的节点
 */
public class DeleteNode {
    public static void main(String[] args) {
        TreeNode treeNode = new DeleteNode().deleteNode(getTreeNode(), 8);

        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        eight.right = nine;
        six.left = five;
        seven.left = six;
        seven.right = eight;
        four.right = seven;


//        TreeNode treeNode = new DeleteNode().deleteNode(eight, 8);
        System.out.println(treeNode);
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null || (root.val == key && isLeaf(root))) {
            return null;
        }

        if (root.val == key) {
            return deleteRoot(root);
        }

        TreeNode deleteNodeParent = null;
        TreeNode pendingDeleteNode = root;
        while (pendingDeleteNode != null && pendingDeleteNode.val != key) {
            int currentValue = pendingDeleteNode.val;
            if (currentValue > key) {
                deleteNodeParent = pendingDeleteNode;
                pendingDeleteNode = pendingDeleteNode.left;
            }
            if (currentValue < key) {
                deleteNodeParent = pendingDeleteNode;
                pendingDeleteNode = pendingDeleteNode.right;
            }
        }

        if (pendingDeleteNode == null) {
            return root;
        }

        boolean isLeft = deleteNodeParent.left != null && deleteNodeParent.left.val == pendingDeleteNode.val;
        TreeNode newNode = deleteRoot(pendingDeleteNode);
        if (isLeft) {
            deleteNodeParent.left = newNode;
        } else {
            deleteNodeParent.right = newNode;
        }
        return root;
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    private TreeNode deleteRoot(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else if (isLeaf(root.left) || root.left.right == null) {
            root.left.right = root.right;
            return root.left;
        } else if (isLeaf(root.right)) {
            root.right.left = root.left;
            return root.right;
        } else {
            TreeNode parentNode = root;
            TreeNode maxNode = root.left;
            while (maxNode.right != null) {
                parentNode = maxNode;
                maxNode = maxNode.right;
            }
            if (isLeaf(maxNode)) {
                parentNode.right = null;
            } else {
                parentNode.right = maxNode.left;
            }
            maxNode.left = root.left;
            maxNode.right = root.right;
            return maxNode;
        }
    }
}
