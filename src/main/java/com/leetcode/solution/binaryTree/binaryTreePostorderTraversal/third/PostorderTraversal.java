package com.leetcode.solution.binaryTree.binaryTreePostorderTraversal.third;

import com.leetcode.solution.binaryTree.TreeNode;
import com.leetcode.solution.binaryTree.binaryTreePostorderTraversal.PostorderTraversalTemplate;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostorderTraversal extends PostorderTraversalTemplate {
    @Override
    public List<Integer> postorderTraversalWithRecursion(TreeNode root) {
        // 思路：递归 => postorder => 左右根
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(postorderTraversalWithRecursion(root.left));
        result.addAll(postorderTraversalWithRecursion(root.right));
        result.add(root.val);
        return result;
    }


    @Override
    public List<Integer> postorderTraversalTwoStack(TreeNode root) {
        // 思路：两个栈改变插入顺序 => postorder => 左右根
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode pop = stack1.pop();
            if (pop.left != null) {
                stack1.push(pop.left);
            }
            if (pop.right != null) {
                stack2.push(pop.right);
            }
            stack2.push(pop);
        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }
        return result;
    }

    @Override
    public List<Integer> postorderTraversal(TreeNode root) {
        // 思路：一个栈模拟递归 => postorder => 左右根 => need visited TreeNode
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


            NodeWithFlag peek = stack.peek();
            if (peek.isVisited()) {
                result.add(stack.pop().getNode().val);
            } else {
                peek.setVisited(true);
                node = peek.getNode().right;
            }
        }
        return result;
    }

    static class NodeWithFlag {
        private boolean visited;
        private final TreeNode node;

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
}
