package com.leetcode.solution.generalQuestionsDFS.theMazeII.first;

import com.leetcode.solution.generalQuestionsDFS.theMazeII.ShortestDistanceTemplate;

public class ShortestDistance extends ShortestDistanceTemplate {
    public static void main(String[] args) {
        System.out.println(new ShortestDistance().shortestDistance(new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 4}, new int[]{4, 4}));
    }

    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, -1, 0, 1};

    @Override
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // Ideas: DFS 二维问题
        // check input
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0 || start == null || start.length == 0 || destination == null || destination.length == 0) {
            return -1;
        }

        // search memo
        int m = maze.length;
        int n = maze[0].length;
        int[][] memo = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        return dfs(maze, memo, visited, start, destination);
    }

    private int dfs(int[][] maze, int[][] memo, boolean[][] visited, int[] start, int[] destination) {
        // hit cache
        if (memo[start[0]][start[1]] != 0) {
            return memo[start[0]][start[1]];
        }

        // pruning
        if (visited[start[0]][start[1]]) {
            return -1;
        }

        // exit recursion
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return 0;
        }

        // construct result
        int result = Integer.MAX_VALUE;
        visited[start[0]][start[1]] = true;

        // move
        for (int i = 0; i < 4; i++) {
            int moveStepNum = 0;
            int x = start[0] + dx[i];
            int y = start[1] + dy[i];
            System.out.println("move");
            while (checkRange(maze, x, y) && maze[x][y] == 0) {
                System.out.println("point -> (" + x + ", " + y + ")");
                moveStepNum++;
                x += dx[i];
                y += dy[i];
            }
            int next = dfs(maze, memo, visited, new int[]{x - dx[i], y - dy[i]}, destination);
            if (next != -1) {
                result = Math.min(result, next + moveStepNum);
            }
        }

        // no movement
        if (result == Integer.MAX_VALUE) {
            memo[start[0]][start[1]] = -1;
            return -1;
        }

        memo[start[0]][start[1]] = result;
        return result;
    }

    private boolean checkRange(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length;
    }
}
