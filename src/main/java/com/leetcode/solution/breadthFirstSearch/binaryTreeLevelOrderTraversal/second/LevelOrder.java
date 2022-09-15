package com.leetcode.solution.breadthFirstSearch.binaryTreeLevelOrderTraversal.second;

import com.leetcode.solution.breadthFirstSearch.TreeNode;
import com.leetcode.solution.breadthFirstSearch.binaryTreeLevelOrderTraversal.LevelOrderTemplate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder extends LevelOrderTemplate {
    @Override
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Ideas: BFS
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (root == null) {
            return result;
        }

        // queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;

        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(list);
        }

        return result;
    }
}
