package com.leetcode.solution.breadthFirstSearch.nAryTreeLevelOrderTraversal.second;

import com.leetcode.solution.breadthFirstSearch.nAryTreeLevelOrderTraversal.LevelOrderTemplate;
import com.leetcode.solution.breadthFirstSearch.nAryTreeLevelOrderTraversal.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder extends LevelOrderTemplate {
    @Override
    public List<List<Integer>> levelOrder(Node root) {
        // Ideas: BFS
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (root == null) {
            return result;
        }

        // queue
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int size;

        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                node.children.forEach(child -> queue.offer(child));
            }

            result.add(list);
        }

        return result;
    }
}
