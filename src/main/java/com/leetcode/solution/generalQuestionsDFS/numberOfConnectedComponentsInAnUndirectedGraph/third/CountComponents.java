package com.leetcode.solution.generalQuestionsDFS.numberOfConnectedComponentsInAnUndirectedGraph.third;

import com.leetcode.solution.breadthFirstSearch.numberOfConnectedComponentsInAnUndirectedGraph.CountComponentsTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountComponents extends CountComponentsTemplate {
    @Override
    public int countComponents(int n, int[][] edges) {
        // Ideas: construct adjacencyList => get connect component
        // check input
        if (n < 1) {
            return -1;
        }

        // construct adjacencyList
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for (int[] item : edges) {
            int u = item[0];
            int v = item[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        // marked
        boolean[] visited = new boolean[n];
        int connectComponentCount = 0;

        // traversal
        for (int node : adjacencyList.keySet()) {
            if (!visited[node]) {
                dfs(adjacencyList, node, visited);
                connectComponentCount++;
            }
        }
        return connectComponentCount;
    }

    private void dfs(Map<Integer, List<Integer>> adjacencyList, int start, boolean[] visited) {
        // marked
        visited[start] = true;

        // traversal adjacency node
        for (int adjacencyNode : adjacencyList.get(start)) {
            if (!visited[adjacencyNode]) {
                dfs(adjacencyList, adjacencyNode, visited);
            }
        }
    }
}
