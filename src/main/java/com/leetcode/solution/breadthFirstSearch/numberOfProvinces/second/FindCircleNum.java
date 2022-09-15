package com.leetcode.solution.breadthFirstSearch.numberOfProvinces.second;

import com.leetcode.solution.breadthFirstSearch.numberOfProvinces.FindCircleNumTemplate;

import java.util.LinkedList;
import java.util.Queue;

public class FindCircleNum extends FindCircleNumTemplate {
    @Override
    public int findCircleNum(int[][] isConnected) {
        // Ideas: BFS => 求连通分量 => isConnected 是邻接矩阵
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
                bfs(isConnected, i, visited);
                connectComponentCount++;
            }
        }

        return connectComponentCount;
    }

    private void bfs(int[][] isConnected, int node, boolean[] visited) {
        // queue
        Queue<Integer> queue = new LinkedList<>();

        // offer & marked
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            // traversal adjacency node
            for (int adjacencyNode = 0; adjacencyNode < isConnected[currentNode].length; adjacencyNode++) {
                if (!visited[adjacencyNode] && isConnected[currentNode][adjacencyNode] == 1) {
                    // offer & marked
                    queue.offer(adjacencyNode);
                    visited[adjacencyNode] = true;
                }
            }
            for (int adjacencyNode : isConnected[currentNode]) {
                if (!visited[adjacencyNode] && isConnected[currentNode][adjacencyNode] == 1) {
                    // offer & marked
                    queue.offer(adjacencyNode);
                    visited[adjacencyNode] = true;
                }
            }
        }
    }
}
