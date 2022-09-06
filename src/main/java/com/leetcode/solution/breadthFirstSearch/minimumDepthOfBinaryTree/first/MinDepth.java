package com.leetcode.solution.breadthFirstSearch.minimumDepthOfBinaryTree.first;

import com.leetcode.solution.breadthFirstSearch.TreeNode;
import com.leetcode.solution.breadthFirstSearch.minimumDepthOfBinaryTree.MinDepthTemplate;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth extends MinDepthTemplate {
    @Override
    public int minDepth(TreeNode root) {
        // Ideas: BFS => queue => find first leaf node
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        int size;

        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }

        return depth;
    }
}
