package com.leetcode.solution.binaryTree.binaryTreePreorderTraversal.second;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.binaryTreePreorderTraversal.PreorderTraversalTemplate;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PreorderTraversal extends PreorderTraversalTemplate {
    @Override
    public List<Integer> preorderTraversal(TreeNode root) {
        // 思路：使用栈模拟递归
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                result.add(node.val);
                node = node.left;
            }
            node = stack.pop().right;
        }
        return result;
    }

    @Override
    public List<Integer> preorderTraversalDepth(TreeNode root) {
        // 思路：使用栈改变顺序，先推入根元素，再推入左子树，再推入右子树
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
        // 思路：递归调用。前序 => 根左右
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.add(root.val);
        if (root.left != null) {
            result.addAll(preorderTraversalWithRecursion(root.left));
        }
        if (root.right != null) {
            result.addAll(preorderTraversalWithRecursion(root.right));
        }
        return result;
    }
}
