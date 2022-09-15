package com.leetcode.solution.breadthFirstSearch.minimumDepthOfBinaryTree.second;

import com.leetcode.solution.breadthFirstSearch.TreeNode;
import com.leetcode.solution.breadthFirstSearch.minimumDepthOfBinaryTree.MinDepthTemplate;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth extends MinDepthTemplate {
    @Override
    public int minDepth(TreeNode root) {
        // Ideas: BFS
        int level = 0;

        // check input
        if (root == null) {
            return level;
        }

        // queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;

        while (true) {
            size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }
}
