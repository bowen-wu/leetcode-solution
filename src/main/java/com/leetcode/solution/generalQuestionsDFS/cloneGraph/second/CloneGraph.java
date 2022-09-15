package com.leetcode.solution.generalQuestionsDFS.cloneGraph.second;

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

        // Map => old node -> new node
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        // hit cache
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for (Node adjacencyNode : node.neighbors) {
            Node newAdjacencyNode = dfs(adjacencyNode, map);
            newNode.neighbors.add(newAdjacencyNode);
        }

        return newNode;
    }
}
