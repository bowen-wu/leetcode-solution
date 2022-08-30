package com.leetcode.solution.binaryTree.binaryTreePreorderTraversal.third;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.binaryTreePreorderTraversal.PreorderTraversalTemplate;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PreorderTraversal extends PreorderTraversalTemplate {
    @Override
    public List<Integer> preorderTraversalWithRecursion(TreeNode root) {
        // 思路：递归遍历 => preorder => 根左右
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.add(root.val);
        result.addAll(preorderTraversalWithRecursion(root.left));
        result.addAll(preorderTraversalWithRecursion(root.right));
        return result;
    }


    @Override
    public List<Integer> preorderTraversalDepth(TreeNode root) {
        // 思路：栈改变节点顺序 => preorder => 根左右
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
    public List<Integer> preorderTraversal(TreeNode root) {
        // 思路：栈模拟递归 => preorder => 根左右
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }

            node = stack.pop().right;
        }

        return result;
    }
}
