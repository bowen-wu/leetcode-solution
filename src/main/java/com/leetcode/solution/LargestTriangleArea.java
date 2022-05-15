package com.leetcode.solution;

/**
 * https://leetcode.cn/problems/largest-triangle-area/
 * 812. 最大三角形面积
 */
public class LargestTriangleArea {
    public static void main(String[] args) {
        System.out.println(new LargestTriangleArea().largestTriangleArea(new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}}));
    }

    // 时间复杂度：O(n ^ 3)
    // 空间复杂度：O(1)
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    result = Math.max(result, getTriangleArea(points[i], points[j], points[k]));
                }
            }
        }
        return result;
    }

    private double getTriangleArea(int[] firstPoint, int[] secondPoint, int[] thirdPoint) {
        return (double) Math.abs((secondPoint[0] - firstPoint[0]) * (thirdPoint[1] - firstPoint[1]) - (thirdPoint[0] - firstPoint[0]) * (secondPoint[1] - firstPoint[1])) / 2;
    }
}
