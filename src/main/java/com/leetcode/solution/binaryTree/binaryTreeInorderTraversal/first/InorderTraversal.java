package com.leetcode.solution.binaryTree.binaryTreeInorderTraversal.first;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.binaryTreeInorderTraversal.InorderTraversalTemplate;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InorderTraversal extends InorderTraversalTemplate {
    @Override
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                // 左
                node = node.left;
            }
            // 父
            node = stack.pop();
            result.add(node.val);

            // 右
            node = node.right;
        }

        return result;
    }

    @Override
    public List<Integer> inorderTraversalWithRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.addAll(inorderTraversalWithRecursion(root.left));
        result.add(root.val);
        result.addAll(inorderTraversalWithRecursion(root.right));
        return result;
    }
}
