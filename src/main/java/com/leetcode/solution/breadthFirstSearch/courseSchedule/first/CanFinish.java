package com.leetcode.solution.breadthFirstSearch.courseSchedule.first;

import com.leetcode.solution.breadthFirstSearch.courseSchedule.CanFinishTemplate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanFinish extends CanFinishTemplate {
    @Override
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Ideas: topological sort
        // check input
        if (numCourses < 1 || prerequisites == null) {
            return false;
        }

        // construct adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
        }

        // construct in degree
        int[] inDegree = new int[numCourses];
        for (List<Integer> adjacencyNodes : adjacencyList) {
            for (int node : adjacencyNodes) {
                inDegree[node] += 1;
            }
        }

        // queue + push node if in degree is 0
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // BFS
        while (!queue.isEmpty()) {
            int node = queue.poll();
            index++;

            for (int adjacencyNode : adjacencyList.get(node)) {
                inDegree[adjacencyNode] -= 1;
                if (inDegree[adjacencyNode] == 0) {
                    queue.offer(adjacencyNode);
                }
            }
        }
        return index == numCourses;
    }
}
