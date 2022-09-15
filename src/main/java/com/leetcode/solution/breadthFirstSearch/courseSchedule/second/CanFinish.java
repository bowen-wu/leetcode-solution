package com.leetcode.solution.breadthFirstSearch.courseSchedule.second;

import com.leetcode.solution.breadthFirstSearch.courseSchedule.CanFinishTemplate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanFinish extends CanFinishTemplate {
    @Override
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Ideas: topolocal sort
        // check input
        if (numCourses < 1 || prerequisites == null) {
            return true;
        }

        // construct adjacency list => int -> List<Integer>
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] item : prerequisites) {
            adjacencyList.get(item[1]).add(item[0]);
        }

        // construct in degree
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int adjacencyNode : adjacencyList.get(i)) {
                inDegree[adjacencyNode] += 1;
            }
        }

        // queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            index++;

            // traversal adjacency node
            for (int adjacencyNode : adjacencyList.get(node)) {
                int newInDegree = inDegree[adjacencyNode] - 1;
                if (newInDegree == 0) {
                    queue.offer(adjacencyNode);
                }
                inDegree[adjacencyNode] = newInDegree;
            }
        }

        return index == numCourses;
    }
}
