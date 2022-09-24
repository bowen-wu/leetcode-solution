package com.leetcode.solution.breadthFirstSearch.numberOfProvinces.third;

import com.leetcode.solution.breadthFirstSearch.numberOfProvinces.FindCircleNumTemplate;

import java.util.LinkedList;
import java.util.Queue;

public class FindCircleNum extends FindCircleNumTemplate {
    @Override
    public int findCircleNum(int[][] isConnected) {
        // Ideas: BFS => get connected component in adjacency matrix
        // check input
        if (isConnected == null || isConnected.length == 0 || isConnected[0] == null || isConnected[0].length == 0) {
            return 0;
        }

        // marked
        boolean[] visited = new boolean[isConnected.length];
        int connectedComponentCount = 0;

        // traversal
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                bfs(isConnected, i, visited);
                connectedComponentCount++;
            }
        }

        return connectedComponentCount;
    }

    private void bfs(int[][] isConnected, int start, boolean[] visited) {
        // queue
        Queue<Integer> queue = new LinkedList<>();

        // offer & mark
        queue.offer(start);
        visited[start] = true;

        // traversal adjacency node
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < isConnected[node].length; i++) {
                if (isConnected[node][i] == 1 && !visited[i]) {
                    // offer & mark
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
