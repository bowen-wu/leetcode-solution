package com.leetcode.solution.binaryTree.binaryTreePostorderTraversal.second;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.binaryTreePostorderTraversal.PostorderTraversalTemplate;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostorderTraversal extends PostorderTraversalTemplate {
    static class NodeWithFlag {
        private boolean visited;
        private TreeNode node;

        public NodeWithFlag(boolean visited, TreeNode node) {
            this.visited = visited;
            this.node = node;
        }

        public TreeNode getNode() {
            return node;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }
    }

    @Override
    public List<Integer> postorderTraversal(TreeNode root) {
        // 思路：一个栈，栈 pop 的时候，应该查看该元素是否被访问过，如果被访问过，那么加入 result
        // 		如果没有，拿到右子树去遍历
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<NodeWithFlag> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(new NodeWithFlag(false, node));
                node = node.left;
            }

            if (stack.peek().isVisited()) {
                result.add(stack.pop().getNode().val);
            } else {
                stack.peek().setVisited(true);
                node = stack.peek().getNode().right;
            }
        }
        return result;
    }

    @Override
    public List<Integer> postorderTraversalTwoStack(TreeNode root) {
        // 思路：两个栈
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
            stack2.push(node);
        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }

        return result;
    }

    @Override
    public List<Integer> postorderTraversalWithRecursion(TreeNode root) {
        // 思路：递归 => 后续遍历 => 左右根
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(postorderTraversalWithRecursion(root.left));
        result.addAll(postorderTraversalWithRecursion(root.right));
        result.add(root.val);
        return result;
    }
}
