package com.leetcode.solution.generalQuestionsDFS.basicMaze.first;

import com.leetcode.solution.generalQuestionsDFS.Point;
import com.leetcode.solution.generalQuestionsDFS.basicMaze.BasicMazeTemplate;

import java.util.ArrayList;
import java.util.List;

public class BasicMaze extends BasicMazeTemplate {
    @Override
    public List<List<Point>> basicMaze(int[][] maze, Point start, Point end) {
        List<List<Point>> result = new ArrayList<>();
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            return result;
        }

        // marked
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        // single result
        List<Point> list = new ArrayList<>();
        list.add(start);
        dfs(result, list, maze, start, end, visited);
        return result;
    }

    private void dfs(List<List<Point>> result, List<Point> list, int[][] maze, Point start, Point end, boolean[][] visited) {
        // pruning
        if (maze[start.x][start.y] == 1) {
            return;
        }

        // marked
        visited[start.x][start.y] = true;

        // exit recursion
        if (start.x == end.x && start.y == end.y) {
            result.add(new ArrayList<>(list));
            return;
        }

        // recursive decomposition to next level + pruning
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            Point newPoint = new Point(start.x + dx[i], start.y + dy[i]);
            if (checkRange(maze, newPoint) && !visited[newPoint.x][newPoint.y]) {
                list.add(newPoint);
                dfs(result, list, maze, newPoint, end, visited);
                list.remove(list.size() - 1);
                Point remove = list.remove(list.size() - 1);
                visited[remove.x][remove.y] = false;
            }
        }
    }

    private boolean checkRange(int[][] maze, Point point) {
        return point.x >= 0 && point.x < maze.length && point.y >= 0 && point.y < maze[0].length;
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
