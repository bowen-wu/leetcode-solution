package com.leetcode.solution.breadthFirstSearch.cloneGraph.second;

import com.leetcode.solution.breadthFirstSearch.cloneGraph.CloneGraphTemplate;
import com.leetcode.solution.breadthFirstSearch.cloneGraph.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph extends CloneGraphTemplate {
    @Override
    public Node cloneGraph(Node node) {
        // Ideas: BFS
        // check input
        if (node == null) {
            return null;
        }

        // Map => old node -> new node
        Map<Node, Node> map = new HashMap<>();

        // queue
        Queue<Node> queue = new LinkedList<>();

        // offer
        queue.offer(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            for (Node neighbor : currentNode.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.get(currentNode).neighbors.add(map.get(neighbor));
                } else {
                    // offer
                    queue.offer(neighbor);
                    Node newNeighbor = new Node(neighbor.val);
                    map.put(neighbor, newNeighbor);
                    map.get(currentNode).neighbors.add(newNeighbor);
                }
            }
        }

        return newNode;
    }
}
