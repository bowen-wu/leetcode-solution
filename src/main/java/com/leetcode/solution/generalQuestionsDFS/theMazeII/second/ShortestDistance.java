package com.leetcode.solution.generalQuestionsDFS.theMazeII.second;

import com.leetcode.solution.generalQuestionsDFS.theMazeII.ShortestDistanceTemplate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance extends ShortestDistanceTemplate {
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, -1, 0, 1};

    @Override
    public int shortestDistanceWithDFS(int[][] maze, int[] start, int[] destination) {
        // Ideas: DFS
        // check input
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0 || start.length != 2 || destination.length != 2) {
            return -1;
        }

        // memory search => start -> (x, y) shortest distance
        int[][] memo = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
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
        // Ideas: BFS
        // check input
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0 || start.length != 2 || destination.length != 2) {
            return -1;
        }

        // memory search
        int[][] memo = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        memo[start[0]][start[1]] = 0;
        bfs(maze, start, memo);
        return memo[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : memo[destination[0]][destination[1]];
    }

    private void bfs(int[][] maze, int[] start, int[][] memo) {
        // queue
        Queue<int[]> queue = new LinkedList<>();

        // offer
        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            // move
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
                    memo[newX][newY] = memo[point[0]][point[1]] + moveStep;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }
}
