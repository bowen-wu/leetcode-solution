package com.leetcode.solution.breadthFirstSearch.maximumDepthOfBinaryTree.third;

import com.leetcode.solution.breadthFirstSearch.TreeNode;
import com.leetcode.solution.breadthFirstSearch.maximumDepthOfBinaryTree.MaxDepthTemplate;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth extends MaxDepthTemplate {
    @Override
    public int maxDepth(TreeNode root) {
        // Ideas: BFS => traversal queue empty
        // check input
        if (root == null) {
            return 0;
        }

        // queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        int level = 0;

        // traversal
        while (!queue.isEmpty()) {
            size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return level;
    }
}
