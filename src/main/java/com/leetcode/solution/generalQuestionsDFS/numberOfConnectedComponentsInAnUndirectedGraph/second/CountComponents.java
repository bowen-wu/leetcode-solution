package com.leetcode.solution.generalQuestionsDFS.numberOfConnectedComponentsInAnUndirectedGraph.second;

import com.leetcode.solution.generalQuestionsDFS.numberOfConnectedComponentsInAnUndirectedGraph.CountComponentsTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountComponents extends CountComponentsTemplate {
    @Override
    public int countComponents(int n, int[][] edges) {
        // Ideas: get connect component => dfs
        // check input
        if (n < 1) {
            return 0;
        }

        // construct adjacency list
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        // marked
        boolean[] visited = new boolean[n];
        int connectComponentCount = 0;

        // traversal all key
        for (int node : adjacencyList.keySet()) {
            if (!visited[node]) {
                helper(adjacencyList, visited, node);
                connectComponentCount++;
            }
        }

        return connectComponentCount;
    }

    private void helper(Map<Integer, List<Integer>> adjacencyList, boolean[] visited, int node) {
        // marked
        visited[node] = true;

        // traversal all adjacency node
        for (int adjacencyNode : adjacencyList.get(node)) {
            if (!visited[adjacencyNode]) {
                helper(adjacencyList, visited, adjacencyNode);
            }
        }
    }
}
