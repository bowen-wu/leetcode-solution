package com.leetcode.solution.breadthFirstSearch.courseSchedule.third;

import com.leetcode.solution.breadthFirstSearch.courseSchedule.CanFinishTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CanFinish extends CanFinishTemplate {
    @Override
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Ideas: Topological Sort
        // check input
        if (numCourses < 1) {
            return true;
        }

        // construct adjacency list
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for (int[] item : prerequisites) {
            adjacencyList.get(item[1]).add(item[0]);
        }

        // calculate in degree
        int[] inDegree = new int[numCourses];
        for (int course : adjacencyList.keySet()) {
            for (int item : adjacencyList.get(course)) {
                inDegree[item] += 1;
            }
        }

        // queue => offer queue if in degree equal 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            index++;

            // adjacency node in degree subtract 1
            for (int adjacencyNode : adjacencyList.get(course)) {
                int newInDegree = inDegree[adjacencyNode] - 1;
                inDegree[adjacencyNode] = newInDegree;
                if (newInDegree == 0) {
                    queue.offer(adjacencyNode);
                }
            }
        }

        return index == numCourses;
    }
}
