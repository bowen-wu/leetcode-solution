package com.leetcode.solution.breadthFirstSearch.maximumDepthOfBinaryTree.first;

import com.leetcode.solution.breadthFirstSearch.TreeNode;
import com.leetcode.solution.breadthFirstSearch.maximumDepthOfBinaryTree.MaxDepthTemplate;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth extends MaxDepthTemplate {
    @Override
    public int maxDepth(TreeNode root) {
        // Ideas: BFS => queue => 遍历到最后
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;
            size = queue.size();
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

        return depth;
    }
}
