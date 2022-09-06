package com.leetcode.solution.breadthFirstSearch.binaryTreeLevelOrderTraversal.first;

import com.leetcode.solution.breadthFirstSearch.TreeNode;
import com.leetcode.solution.breadthFirstSearch.binaryTreeLevelOrderTraversal.LevelOrderTemplate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder extends LevelOrderTemplate {
    @Override
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Ideas: BFS => queue => 记录每层，使用 for loop
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size;

        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> list = new ArrayList<>(size);

            // for loop 层级遍历
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
