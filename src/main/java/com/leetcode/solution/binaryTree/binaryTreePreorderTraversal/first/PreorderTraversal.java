package com.leetcode.solution.binaryTree.binaryTreePreorderTraversal.first;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.binaryTreePreorderTraversal.PreorderTraversalTemplate;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PreorderTraversal extends PreorderTraversalTemplate {
    @Override
    public List<Integer> preorderTraversalDepth(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                // 根
                result.add(node.val);
                stack.push(node);

                // 左
                node = node.left;
            }
            node = stack.pop();

            // 右
            node = node.right;
        }
        return result;
    }

    @Override
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    @Override
    public List<Integer> preorderTraversalWithRecursion(TreeNode root) {
        // 时间复杂度：O() ? => 感觉是范围值，因为树的结构不知道
        // 空间复杂度：O(1) result 不算
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.add(root.val);
        result.addAll(preorderTraversalWithRecursion(root.left));
        result.addAll(preorderTraversalWithRecursion(root.right));
        return result;
    }
}
