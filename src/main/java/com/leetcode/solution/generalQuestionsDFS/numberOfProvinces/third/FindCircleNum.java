package com.leetcode.solution.generalQuestionsDFS.numberOfProvinces.third;

import com.leetcode.solution.breadthFirstSearch.numberOfProvinces.FindCircleNumTemplate;

public class FindCircleNum extends FindCircleNumTemplate {
    @Override
    public int findCircleNum(int[][] isConnected) {
        // Ideas: adjacency matrix => get connect component
        // check input
        if (isConnected == null || isConnected.length == 0 || isConnected[0] == null || isConnected[0].length == 0) {
            return -1;
        }

        // marked
        boolean[] visited = new boolean[isConnected.length];
        int connectComponentCount = 0;

        // traversal
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                connectComponentCount++;
            }
        }
        return connectComponentCount;
    }

    private void dfs(int[][] isConnected, int start, boolean[] visited) {
        // marked
        visited[start] = true;

        // traversal adjacency node
        for (int i = 0; i < isConnected[start].length; i++) {
            if (isConnected[start][i] == 1 && !visited[i]) {
                dfs(isConnected, i, visited);
            }
        }
    }
}
