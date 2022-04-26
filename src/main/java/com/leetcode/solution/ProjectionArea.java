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
        for (int i = 0; i < grid.length; i++) {
            int sideViewMax = 0;
            int frontViewMax = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    // 俯视图
                    result += 1;
                }

                // 侧视图
                sideViewMax = Math.max(sideViewMax, grid[i][j]);

                // 正视图
                frontViewMax = Math.max(frontViewMax, grid[j][i]);
            }
            result += sideViewMax;
            result += frontViewMax;
        }
        return result;
    }
}
