package com.leetcode.solution.breadthFirstSearch.numberOfConnectedComponentsInAnUndirectedGraph.first;

import com.leetcode.solution.breadthFirstSearch.numberOfConnectedComponentsInAnUndirectedGraph.CountComponentsTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CountComponents extends CountComponentsTemplate {
    @Override
    public int countComponents(int n, int[][] edges) {
        // Ideas: BFS
        // 1. construct adjacency list
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

        for (int start : adjacencyList.keySet()) {
            if (!visited[start]) {
                helper(adjacencyList, visited, start);
                connectComponentCount++;
            }
        }
        return connectComponentCount;
    }

    private void helper(Map<Integer, List<Integer>> adjacencyList, boolean[] visited, int start) {
        // queue
        Queue<Integer> queue = new LinkedList<>();

        // offer & marked
        queue.offer(start);
        visited[start] = true;

        // traversal
        while (!queue.isEmpty()) {
            int node = queue.poll();

            // traversal
            for (int neighbor : adjacencyList.get(node)) {
                if (!visited[neighbor]) {
                    // offer & marked
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}
