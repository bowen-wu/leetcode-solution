package com.leetcode.solution.binaryTree.binaryTreeInorderTraversal.third;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.binaryTreeInorderTraversal.InorderTraversalTemplate;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InorderTraversal extends InorderTraversalTemplate {
    @Override
    public List<Integer> inorderTraversalWithRecursion(TreeNode root) {
        // 思路：递归 => inorder => 左根右
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.addAll(inorderTraversalWithRecursion(root.left));
        result.add(root.val);
        result.addAll(inorderTraversalWithRecursion(root.right));
        return result;
    }

    @Override
    public List<Integer> inorderTraversal(TreeNode root) {
        // 思路：栈模拟递归 => inorder => 左根右
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            TreeNode pop = stack.pop();
            result.add(pop.val);
            node = pop.right;
        }
        return result;
    }

}
