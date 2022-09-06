package com.leetcode.solution.breadthFirstSearch.nAryTreeLevelOrderTraversal.first;

import com.leetcode.solution.breadthFirstSearch.nAryTreeLevelOrderTraversal.LevelOrderTemplate;
import com.leetcode.solution.breadthFirstSearch.nAryTreeLevelOrderTraversal.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder extends LevelOrderTemplate {
    @Override
    public List<List<Integer>> levelOrder(Node root) {
        // Ideas: BFS => queue
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int size;

        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                node.children.forEach(child -> {
                    if (child != null) {
                        queue.offer(child);
                    }
                });
            }

            result.add(list);
        }

        return result;
    }
}
