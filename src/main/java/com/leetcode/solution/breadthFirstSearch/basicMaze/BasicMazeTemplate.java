package com.leetcode.solution.breadthFirstSearch.basicMaze;

import com.leetcode.solution.generalQuestionsDFS.Point;

/**
 * 基础迷宫
 * 有一个迷宫，由黑色方块（用1代表）与白色方块（用0代表）组成，黑色方块代表障碍物，白色代表可以通过区域
 * 请找到最短一条可以从起点S走到终点E的道路，返回最短距离
 */
abstract public class BasicMazeTemplate {
    abstract public int getShortPathStep(int[][] maze, Point start, Point end);
}

