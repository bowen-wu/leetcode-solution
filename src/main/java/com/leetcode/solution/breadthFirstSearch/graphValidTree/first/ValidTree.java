package com.leetcode.solution.breadthFirstSearch.graphValidTree.first;

import com.leetcode.solution.breadthFirstSearch.graphValidTree.ValidTreeTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ValidTree extends ValidTreeTemplate {
    @Override
    public boolean validTree(int n, int[][] edges) {
        // Ideas: BFS => 连通分量 == 1 && 边数 == 节点数 - 1
        if (edges == null) {
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
        int connectComponentCount = 0;

        // traversal
        for (int start : adjacencyList.keySet()) {
            if (!visited[start]) {
                bfs(adjacencyList, visited, start);
                connectComponentCount++;
            }
        }
        return connectComponentCount == 1;
    }

    private void bfs(Map<Integer, List<Integer>> adjacencyList, boolean[] visited, int start) {
        // queue
        Queue<Integer> queue = new LinkedList<>();

        // offer & marked
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int adjacencyNode : adjacencyList.get(node)) {
                if (!visited[adjacencyNode]) {
                    // offer & marked
                    queue.offer(adjacencyNode);
                    visited[adjacencyNode] = true;
                }
            }
        }
    }
}
