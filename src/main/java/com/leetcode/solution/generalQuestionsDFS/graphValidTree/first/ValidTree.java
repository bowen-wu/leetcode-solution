package com.leetcode.solution.generalQuestionsDFS.graphValidTree.first;

import com.leetcode.solution.generalQuestionsDFS.graphValidTree.ValidTreeTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidTree extends ValidTreeTemplate {
    @Override
    public boolean validTree(int n, int[][] edges) {
        // Ideas: tree => edges == nodeNumbers - 1 && 连通分量 == 1
        if (n < 1) {
            return false;
        }

        if (edges.length != n - 1) {
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
        int count = 0;

        for (int item : adjacencyList.keySet()) {
            if (!visited[item]) {
                dfs(adjacencyList, visited, item);
                count++;
            }
        }

        return count == 1;
    }

    private void dfs(Map<Integer, List<Integer>> adjacencyList, boolean[] visited, int start) {
        visited[start] = true;
        for (int item : adjacencyList.get(start)) {
            if (!visited[item]) {
                dfs(adjacencyList, visited, item);
            }
        }
    }
}
