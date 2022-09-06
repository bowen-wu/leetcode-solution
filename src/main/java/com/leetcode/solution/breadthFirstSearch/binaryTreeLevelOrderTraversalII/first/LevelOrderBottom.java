package com.leetcode.solution.breadthFirstSearch.binaryTreeLevelOrderTraversalII.first;

import com.leetcode.solution.breadthFirstSearch.TreeNode;
import com.leetcode.solution.breadthFirstSearch.binaryTreeLevelOrderTraversalII.LevelOrderBottomTemplate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom extends LevelOrderBottomTemplate {
    @Override
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // Ideas: BFS => queue => for loop level traversal => list.add(int index, T node)
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> list = new ArrayList<>(size);
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

            result.add(0, list);
        }
        return result;
    }
}
