package com.leetcode.solution.breadthFirstSearch.courseScheduleII.third;

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
        // Ideas: topological sort
        // check input
        if (numCourses < 1) {
            return new int[0];
        }

        // construct adjacency list
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for (int[] item : prerequisites) {
            adjacencyList.get(item[1]).add(item[0]);
        }

        // in degree => int -> int
        int[] inDegree = new int[numCourses];
        for (int course : adjacencyList.keySet()) {
            for (int i : adjacencyList.get(course)) {
                inDegree[i] += 1;
            }
        }

        // queue => offer queue if in degree equal 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        // traversal
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course;

            // adjacency node in degree subtract 1
            for (int adjacencyNode : adjacencyList.get(course)) {
                int newInDegree = inDegree[adjacencyNode] - 1;
                inDegree[adjacencyNode] = newInDegree;
                if (newInDegree == 0) {
                    queue.offer(adjacencyNode);
                }
            }
        }

        return index == numCourses ? result : new int[0];
    }
}
