package com.leetcode.solution.generalQuestionsDFS.basicMaze.second;

import com.leetcode.solution.generalQuestionsDFS.Point;
import com.leetcode.solution.generalQuestionsDFS.basicMaze.BasicMazeTemplate;

import java.util.ArrayList;
import java.util.List;

public class BasicMaze extends BasicMazeTemplate {
    private final int[] dx = {0, -1, 0, 1};
    private final int[] dy = {1, 0, -1, 0};

    @Override
    public List<List<Point>> basicMaze(int[][] maze, Point start, Point end) {
        // Ideas: dfs 二维矩阵
        // check input
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            return null;
        }

        // marked
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        List<List<Point>> result = new ArrayList<>();
        List<Point> list = new ArrayList<>();
        list.add(start);

        // traversal
        dfs(result, list, maze, start, end, visited);

        return result;
    }

    private void dfs(List<List<Point>> result, List<Point> list, int[][] maze, Point start, Point end, boolean[][] visited) {
        // single result add to solution set => deep copy
        if (start.x == end.x && start.y == end.y) {
            result.add(new ArrayList<>(list));
            return;
        }

        // marked
        visited[start.x][start.y] = true;

        // recursive decomponsiton sub problem to next level => move
        for (int i = 0; i < 4; i++) {
            int newX = start.x + dx[i];
            int newY = start.y + dy[i];

            // pruning
            if (checkRange(maze, newX, newY) && !visited[newX][newY] && maze[newX][newY] == 0) {
                Point newPoint = new Point(newX, newY);
                list.add(newPoint);
                dfs(result, list, maze, newPoint, end, visited);

                // how to backtracking
                list.remove(list.size() - 1);
                visited[newX][newY] = false;
            }
        }
    }

    private boolean checkRange(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0, 0},
                {0, 1, 0, 1},
                {0, 1, 0, 0},
                {0, 0, 0, 0}};
        List<List<Point>> paths = new BasicMaze().basicMaze(maze, new Point(0, 3), new Point(3, 0));
        for (List<Point> path : paths) {
            System.out.println("Path: ");
            path.forEach(point -> System.out.println("(" + point.x + ", " + point.y + ")"));
        }
    }
}
