package com.leetcode.solution.breadthFirstSearch.cloneGraph.third;

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

        // map => oldNode -> newNode
        Map<Node, Node> map = new HashMap<>();

        // queue
        Queue<Node> queue = new LinkedList<>();

        // offer & mark
        queue.offer(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        // traversal
        while (!queue.isEmpty()) {
            Node oldNode = queue.poll();
            Node currentNode = map.get(oldNode);
            for (Node neighbor : oldNode.neighbors) {
                if (map.containsKey(neighbor)) {
                    currentNode.neighbors.add(map.get(neighbor));
                } else {
                    // offer & mark
                    queue.offer(neighbor);
                    Node newNeighbor = new Node(neighbor.val);
                    map.put(neighbor, newNeighbor);
                    currentNode.neighbors.add(newNeighbor);
                }
            }
        }

        return newNode;
    }
}
