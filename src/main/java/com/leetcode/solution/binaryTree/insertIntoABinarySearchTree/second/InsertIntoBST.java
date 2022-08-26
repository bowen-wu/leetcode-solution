package com.leetcode.solution.binaryTree.insertIntoABinarySearchTree.second;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.insertIntoABinarySearchTree.InsertIntoBSTTemplate;

public class InsertIntoBST extends InsertIntoBSTTemplate {
    @Override
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 思路：二分
        // 		1. 如果是空树 => 直接返回以 val 为根节点的树
        // 		2. 二分遍历的时候，如果 left | right 是 null，则直接插入并返回
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode node = root;
        while (node != null) {
            if (node.val == val) {
                return null;
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
        return root;
    }
}
