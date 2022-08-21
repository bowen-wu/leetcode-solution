package com.leetcode.solution.binaryTree.binaryTreePostorderTraversal.first;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.binaryTreePostorderTraversal.PostorderTraversalTemplate;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostorderTraversal extends PostorderTraversalTemplate {
    static class NodeWithFlag {
        private TreeNode node;
        private boolean visited;

        public NodeWithFlag(TreeNode node, boolean visited) {
            this.node = node;
            this.visited = visited;
        }

        public TreeNode getNode() {
            return node;
        }

        public void setNode(TreeNode node) {
            this.node = node;
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
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<NodeWithFlag> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(new NodeWithFlag(node, false));
                node = node.left;
            }
            NodeWithFlag pop = stack.pop();
            if (pop.isVisited()) {
                // 被访问过，就不用 care right 了
                result.add(pop.getNode().val);
            } else {
                // 没有被访问过，需要去访问 right
                pop.setVisited(true);
                stack.push(pop);
                node = pop.getNode().right;
            }
        }
        return result;
    }

    @Override
    public List<Integer> postorderTraversalTwoStack(TreeNode root) {
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
