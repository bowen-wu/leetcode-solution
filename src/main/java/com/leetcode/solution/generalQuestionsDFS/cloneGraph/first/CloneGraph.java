package com.leetcode.solution.generalQuestionsDFS.cloneGraph.first;

import com.leetcode.solution.generalQuestionsDFS.cloneGraph.CloneGraphTemplate;
import com.leetcode.solution.generalQuestionsDFS.cloneGraph.Node;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph extends CloneGraphTemplate {
    @Override
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // oldNode -> newNode
        Map<Node, Node> visited = new HashMap<>();
//        return helper(node, visited);
        return dfs(node, visited);
    }

    private Node dfs(Node oldNode, Map<Node, Node> visited) {
        // hit cache
        if (visited.containsKey(oldNode)) {
            return visited.get(oldNode);
        }

        Node newNode = new Node(oldNode.val);
        visited.put(oldNode, newNode);
        for (Node neighbor : oldNode.neighbors) {
            Node newNeighbor = dfs(neighbor, visited);
            newNode.neighbors.add(newNeighbor);
        }
        return newNode;
    }

    private Node helper(Node oldNode, Map<Node, Node> visited) {
        Node newNode = new Node(oldNode.val);
        visited.put(oldNode, newNode);
        for (Node neighbor : oldNode.neighbors) {
            if (visited.containsKey(neighbor)) {
                newNode.neighbors.add(visited.get(neighbor));
            } else {
                Node newNeighbor = helper(neighbor, visited);
                newNode.neighbors.add(newNeighbor);
            }
        }

        return newNode;
    }
}
