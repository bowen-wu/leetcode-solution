package com.leetcode.solution.breadthFirstSearch.cloneGraph.first;

import com.leetcode.solution.breadthFirstSearch.cloneGraph.CloneGraphTemplate;
import com.leetcode.solution.breadthFirstSearch.cloneGraph.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph extends CloneGraphTemplate {
    @Override
    public Node cloneGraph(Node node) {
        // Ideas: BFS traversal graph =>
        // 1. add to neighbor when hit cache
        // 2. offer old node + create new node + update cache + add to neighbor
        if (node == null) {
            return null;
        }

        // oldNode -> newNode
        Map<Node, Node> cache = new HashMap<>();
        Node result = new Node(node.val);

        // queue
        Queue<Node> queue = new LinkedList<>();

        // offer & marked
        queue.add(node);
        cache.put(node, result);

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            Node newNode = cache.get(poll);

            for (Node neighbor : poll.neighbors) {
                if (cache.containsKey(neighbor)) {
                    // created
                    newNode.neighbors.add(cache.get(neighbor));
                } else {
                    // offer & marked
                    queue.offer(neighbor);
                    Node newNeighbor = new Node(neighbor.val);
                    cache.put(neighbor, newNeighbor);
                    newNode.neighbors.add(newNeighbor);
                }
            }
        }

        return result;
    }
}
