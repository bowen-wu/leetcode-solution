package com.leetcode.solution.generalQuestionsDFS.graphValidTree.second;

import com.leetcode.solution.generalQuestionsDFS.graphValidTree.ValidTreeTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidTree extends ValidTreeTemplate {
    @Override
    public boolean validTree(int n, int[][] edges) {
        // Ideas: n - 1 == edges.length && connectComponentCount == 1 => bfs
        // check input
        if (n < 1) {
            return false;
        }

        if (n - 1 != edges.length) {
            return false;
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

        // traversal
        for (int node : adjacencyList.keySet()) {
            if (!visited[node]) {
                dfs(adjacencyList, visited, node);
                connectComponentCount++;
            }
        }

        return connectComponentCount == 1;
    }

    private void dfs(Map<Integer, List<Integer>> adjacencyList, boolean[] visited, int node) {
        // marked
        visited[node] = true;

        // traversal adjacency node
        for (int adjacencyNode : adjacencyList.get(node)) {
            if (!visited[adjacencyNode]) {
                dfs(adjacencyList, visited, adjacencyNode);
            }
        }
    }
}
