package com.leetcode.solution.generalQuestionsDFS.theMaze.first;

import com.leetcode.solution.generalQuestionsDFS.theMaze.HasPathTemplate;

public class HasPath extends HasPathTemplate {
    public static void main(String[] args) {
        System.out.println(new HasPath().hasPath(new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 4}, new int[]{3, 2}));
    }

    @Override
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // Ideas: 二维矩阵 DFS => 球在遇到墙壁前不会停止滚动。当球停下时，可以选择向下一个方向滚动
        // check input
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0 || start == null || start.length == 0 || destination == null || destination.length == 0) {
            return false;
        }

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
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
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        for (int i = 0; i < 4; i++) {
            // 球在遇到墙壁前不会停止滚动
            int newX = start[0];
            int newY = start[1];
            while (checkRange(maze, newX + dx[i], newY + dy[i]) && maze[newX + dx[i]][newY + dy[i]] == 0) {
                newX += dx[i];
                newY += dy[i];
            }

            // 撞到墙了，退一步
            boolean result = dfs(maze, new int[]{newX, newY}, destination, visited);
            if (result) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRange(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length;
    }
}
