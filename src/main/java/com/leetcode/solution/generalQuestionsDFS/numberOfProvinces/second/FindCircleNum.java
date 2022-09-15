package com.leetcode.solution.generalQuestionsDFS.numberOfProvinces.second;

import com.leetcode.solution.generalQuestionsDFS.numberOfProvinces.FindCircleNumTemplate;

public class FindCircleNum extends FindCircleNumTemplate {
    @Override
    public int findCircleNum(int[][] isConnected) {
        // Ideas: get connect components => dfs
        // check input
        if (isConnected == null || isConnected.length == 0 || isConnected[0] == null || isConnected[0].length == 0) {
            return 0;
        }

        // marked
        boolean[] visited = new boolean[isConnected.length];
        int connectComponentCount = 0;

        // traversal
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                connectComponentCount++;
            }
        }

        return connectComponentCount;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int node) {
        // marked
        visited[node] = true;

        // traversal adjacency node
        for (int i = 0; i < isConnected[node].length; i++) {
            if (isConnected[node][i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
    }
}
