package com.leetcode.solution.generalQuestionsDFS.numberOfConnectedComponentsInAnUndirectedGraph.first;

import com.leetcode.solution.generalQuestionsDFS.numberOfConnectedComponentsInAnUndirectedGraph.CountComponentsTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountComponents extends CountComponentsTemplate {
    public static void main(String[] args) {
        System.out.println(new CountComponents().countComponents(1, new int[0][0]));
    }

    @Override
    public int countComponents(int n, int[][] edges) {
        // construct adjacency list
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        // 解决孤点
        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        // marked
        boolean[] visited = new boolean[n];
        int count = 0;

        // start traversal
        for (int item : adjacencyList.keySet()) {
            if (!visited[item]) {
                dfs(adjacencyList, visited, item);
                count++;
            }
        }

        return count;
    }

    private void dfs(Map<Integer, List<Integer>> adjacencyList, boolean[] visited, int start) {
        // marked
        visited[start] = true;

        // DFS traversal
        for (int item : adjacencyList.get(start)) {
            if (!visited[item]) {
                dfs(adjacencyList, visited, item);
            }
        }
    }
}
