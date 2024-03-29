package com.leetcode.solution.generalQuestionsDFS.theMazeII.first;

import com.leetcode.solution.generalQuestionsDFS.theMazeII.ShortestDistanceTemplate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance extends ShortestDistanceTemplate {
    public static void main(String[] args) {
        System.out.println(new ShortestDistance().shortestDistanceWithDFS(new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 4}, new int[]{4, 4}));
    }

    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, -1, 0, 1};

    @Override
    public int shortestDistanceWithDFS(int[][] maze, int[] start, int[] destination) {
        // Ideas: DFS 二维问题
        // check input
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0 || start == null || start.length == 0 || destination == null || destination.length == 0) {
            return -1;
        }

        // search memo
        int[][] memo = new int[maze.length][maze[0].length];
        for (int[] item : memo) {
            Arrays.fill(item, Integer.MAX_VALUE);
        }
        memo[start[0]][start[1]] = 0;
        dfs(maze, memo, start);
        return memo[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : memo[destination[0]][destination[1]];
    }

    private void dfs(int[][] maze, int[][] memo, int[] start) {
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
                dfs(maze, memo, new int[]{newX, newY});
            }
        }
    }

    @Override
    public int shortestDistanceWithBFS(int[][] maze, int[] start, int[] destination) {
        // check input
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0 || start == null || start.length != 2 || destination == null || destination.length != 2) {
            return -1;
        }

        // construct memo search => start 到 memo[i][j] 的最短距离
        int[][] memo = new int[maze.length][maze[0].length];
        for (int[] item : memo) {
            Arrays.fill(item, Integer.MAX_VALUE);
        }

        // queue
        Queue<int[]> queue = new LinkedList<>();

        // offer & marked
        queue.offer(start);
        memo[start[0]][start[1]] = 0;

        // traversal
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = point[0];
                int newY = point[1];
                int moveSteps = 0;
                while (checkRange(maze, newX + dx[i], newY + dy[i]) && maze[newX + dx[i]][newY + dy[i]] == 0) {
                    newX += dx[i];
                    newY += dy[i];
                    moveSteps++;
                }

                // offer & marked
                if (memo[newX][newY] > memo[point[0]][point[1]] + moveSteps) {
                    memo[newX][newY] = memo[point[0]][point[1]] + moveSteps;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return memo[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : memo[destination[0]][destination[1]];
    }

    private boolean checkRange(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length;
    }
}
