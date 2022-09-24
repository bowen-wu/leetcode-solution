package com.leetcode.solution.generalQuestionsDFS.theMazeII.third;

import com.leetcode.solution.generalQuestionsDFS.theMazeII.ShortestDistanceTemplate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance extends ShortestDistanceTemplate {
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, -1, 0, 1};

    @Override
    public int shortestDistanceWithDFS(int[][] maze, int[] start, int[] destination) {
        // Ideas: DFS => two dimensional matrix
        // 思路：使用 memo search 记录 start 到 (x, y) 的最短距离，移动到新的位置后
        //      如果新位置的距离大，则更新
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0 || start.length != 2 || destination.length != 2) {
            return -1;
        }

        // memo search => start -> (x, y) short distince
        int[][] memo = new int[maze.length][maze[0].length];
        for (int[] item : memo) {
            Arrays.fill(item, Integer.MAX_VALUE);
        }
        memo[start[0]][start[1]] = 0;

        dfs(maze, start, destination, memo);

        return memo[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : memo[destination[0]][destination[1]];
    }

    private void dfs(int[][] maze, int[] start, int[] destination, int[][] memo) {
        // exit recursion
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return;
        }

        // move
        for (int i = 0; i < 4; i++) {
            int newX = start[0];
            int newY = start[1];
            int moveStep = 0;
            while (checkRange(maze, newX + dx[i], newY + dy[i]) && maze[newX + dx[i]][newY + dy[i]] == 0) {
                newX += dx[i];
                newY += dy[i];
                moveStep++;
            }
            if (memo[newX][newY] > memo[start[0]][start[1]] + moveStep) {
                memo[newX][newY] = memo[start[0]][start[1]] + moveStep;
                dfs(maze, new int[]{newX, newY}, destination, memo);
            }
        }
    }

    private boolean checkRange(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length;
    }

    @Override
    public int shortestDistanceWithBFS(int[][] maze, int[] start, int[] destination) {
        // Ideas: BFS => two dimensional matrix
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0 || start.length != 2 || destination.length != 2) {
            return -1;
        }

        // memo search => start -> (x, y) shortest distince
        int[][] memo = new int[maze.length][maze[0].length];
        for (int[] item : memo) {
            Arrays.fill(item, Integer.MAX_VALUE);
        }

        // queue
        Queue<int[]> queue = new LinkedList<>();

        // offer & mark
        queue.offer(start);
        memo[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = point[0];
                int newY = point[1];
                int moveStep = 0;
                while (checkRange(maze, newX + dx[i], newY + dy[i]) && maze[newX + dx[i]][newY + dy[i]] == 0) {
                    newX += dx[i];
                    newY += dy[i];
                    moveStep++;
                }
                if (memo[newX][newY] > memo[point[0]][point[1]] + moveStep) {
                    // offer & mark
                    queue.offer(new int[]{newX, newY});
                    memo[newX][newY] = memo[point[0]][point[1]] + moveStep;
                }
            }
        }

        return memo[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : memo[destination[0]][destination[1]];
    }
}
