package com.leetcode.solution.breadthFirstSearch.basicMaze.first;

import com.leetcode.solution.breadthFirstSearch.basicMaze.BasicMazeTemplate;
import com.leetcode.solution.generalQuestionsDFS.Point;

import java.util.LinkedList;
import java.util.Queue;

public class BasicMaze extends BasicMazeTemplate {
    private final int[] dx = {0, -1, 0, 1};
    private final int[] dy = {1, 0, -1, 0};

    @Override
    public int getShortPathStep(int[][] maze, Point start, Point end) {
        // check input
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            return -1;
        }

        // queue
        Queue<Point> queue = new LinkedList<>();

        // offer & marked
        queue.offer(start);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[start.x][start.y] = true;

        int level = 0;
        int size;

        while (!queue.isEmpty()) {
            size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (point.x == end.x && point.y == end.y) {
                    return level;
                }

                // move
                for (int j = 0; j < 4; j++) {
                    int newX = point.x + dx[j];
                    int newY = point.y + dy[j];

                    if (checkRange(maze, newX, newY) && !visited[newX][newY] && maze[newX][newY] == 0) {
                        // offer & marked
                        queue.offer(new Point(newX, newY));
                        visited[newX][newY] = true;
                    }
                }

            }
        }

        return -1;
    }

    private boolean checkRange(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
        };
        System.out.println(new BasicMaze().getShortPathStep(maze, new Point(0, 1), new Point(5, 4)));
    }
}
