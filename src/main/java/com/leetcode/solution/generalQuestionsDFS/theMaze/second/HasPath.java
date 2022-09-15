package com.leetcode.solution.generalQuestionsDFS.theMaze.second;

import com.leetcode.solution.generalQuestionsDFS.theMaze.HasPathTemplate;

public class HasPath extends HasPathTemplate {
    private final int[] dx = {0, -1, 0, 1};
    private final int[] dy = {1, 0, -1, 0};

    @Override
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // Ideas: dfs
        // check input
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0 || start == null || start.length != 2 || destination == null || destination.length != 2) {
            return false;
        }

        // marked
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, visited, start, destination);
    }

    private boolean dfs(int[][] maze, boolean[][] visited, int[] start, int[] destination) {
        // pruning
        if (visited[start[0]][start[1]]) {
            return false;
        }

        // exit recursion
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }

        // marked
        visited[start[0]][start[1]] = true;

        // move
        for (int i = 0; i < 4; i++) {
            int newX = start[0] + dx[i];
            int newY = start[1] + dy[i];

            while (checkRange(maze, newX, newY) && maze[newX][newY] == 0) {
                newX += dx[i];
                newY += dy[i];
            }

            boolean next = dfs(maze, visited, new int[]{newX - dx[i], newY - dy[i]}, destination);
            if (next == true) {
                return true;
            }
        }

        return false;
    }

    private boolean checkRange(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length;
    }
}
