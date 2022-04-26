package com.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/projection-area-of-3d-shapes/
 * 883. 三维形体投影面积
 */
public class ProjectionArea {
    public static void main(String[] args) {
        System.out.println(new ProjectionArea().projectionArea(new int[][]{{1, 2}, {3, 4}}));
    }

    // 时间复杂度：O(n * n)
    // 空间复杂度：O(1)
    public int projectionArea(int[][] grid) {
        int result = 0;
        int[] frontViewList = new int[grid.length];
        int[] sideViewList = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    // 俯视图
                    result += 1;
                }
                if (sideViewList[i] < grid[i][j]) {
                    // 侧视图
                    result += (grid[i][j] - sideViewList[i]);
                    sideViewList[i] = grid[i][j];
                }
                if (frontViewList[j] < grid[i][j]) {
                    // 正视图
                    result += (grid[i][j] - frontViewList[j]);
                    frontViewList[j] = grid[i][j];
                }
            }
        }
        return result;
    }
}
