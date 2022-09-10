package com.leetcode.solution.breadthFirstSearch.courseScheduleII.first;

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
        // Ideas: Topological Sorting
        // check input
        if (numCourses < 1 || prerequisites == null) {
            return new int[0];
        }

        // construct adjacency list
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
        }

        // construct in degree
        int[] inDegree = new int[numCourses];
        adjacencyList.forEach((key, value) -> {
            for (int node : value) {
                inDegree[node] += 1;
            }
        });

        // queue
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];
        int index = 0;

        // get in degree is 0 and push queue
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // BFS
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            result[index] = poll;
            index++;

            // adjacency node in degree subtract 1 => push queue if in degree is 0
            for (int node : adjacencyList.get(poll)) {
                inDegree[node] -= 1;
                if (inDegree[node] == 0) {
                    queue.offer(node);
                }
            }
        }

        if (index == numCourses) {
            return result;
        }
        return new int[0];
    }
}
