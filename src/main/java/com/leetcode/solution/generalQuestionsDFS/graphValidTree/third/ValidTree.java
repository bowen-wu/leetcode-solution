package com.leetcode.solution.generalQuestionsDFS.graphValidTree.third;

import com.leetcode.solution.breadthFirstSearch.graphValidTree.ValidTreeTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidTree extends ValidTreeTemplate {
    @Override
    public boolean validTree(int n, int[][] edges) {
        // Ideas: nodeNum = edges.length + 1 && connectComponent == 1
        // check input
        if (n < 1) {
            return true;
        }

        if (n != edges.length + 1) {
            return false;
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
        return connectComponentCount == 1;
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
