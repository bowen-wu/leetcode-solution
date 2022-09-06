package com.leetcode.solution.breadthFirstSearch.binaryTreeZigzagLevelOrderTraversal.first;

import com.leetcode.solution.backtracking.pathSumII.second.PathSum;
import com.leetcode.solution.breadthFirstSearch.TreeNode;
import com.leetcode.solution.breadthFirstSearch.binaryTreeZigzagLevelOrderTraversal.ZigzagLevelOrderTemplate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder extends ZigzagLevelOrderTemplate {
    @Override
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // Ideas: BFS => queue => zigzag => result.size() % 2 == 0 ? list.add(node.val) : list.add(0, node.val)
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> list = new ArrayList<>();
            int length = result.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (length % 2 == 0) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
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
