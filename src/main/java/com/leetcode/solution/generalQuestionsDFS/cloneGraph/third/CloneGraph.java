package com.leetcode.solution.generalQuestionsDFS.cloneGraph.third;

import com.leetcode.solution.generalQuestionsDFS.cloneGraph.CloneGraphTemplate;
import com.leetcode.solution.generalQuestionsDFS.cloneGraph.Node;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph extends CloneGraphTemplate {
    @Override
    public Node cloneGraph(Node node) {
        // Ideas: dfs
        // check input
        if (node == null) {
            return null;
        }

        // Map => oldNode -> newNode
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for (Node neighbor : node.neighbors) {
            Node newNeighbor = map.containsKey(neighbor) ? map.get(neighbor) : dfs(neighbor, map);
            newNode.neighbors.add(newNeighbor);
        }

        return newNode;
    }
}
