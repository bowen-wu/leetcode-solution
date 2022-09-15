package com.leetcode.solution.breadthFirstSearch.courseScheduleII.second;

import com.leetcode.solution.breadthFirstSearch.courseScheduleII.FindOrderTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FindOrder extends FindOrderTemplate {
    @Override
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Ideas: Topological sort => in degree
        // check input
        if (numCourses < 1) {
            return new int[0];
        }

        // construct adjacencyList => map => int -> List<>
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adjacencyList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // in degree => int -> int
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int node : adjacencyList.get(i)) {
                inDegree[node] += 1;
            }
        }

        // queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[index] = node;
            index++;

            // adjacency node in degree substract 1
            for (int adjacencyNode : adjacencyList.get(node)) {
                int newInDegree = inDegree[adjacencyNode] - 1;
                if (newInDegree == 0) {
                    queue.offer(adjacencyNode);
                }
                inDegree[adjacencyNode] = newInDegree;
            }
        }

        return index == numCourses ? result : new int[0];
    }
}
