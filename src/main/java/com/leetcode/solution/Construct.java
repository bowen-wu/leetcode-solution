package com.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/construct-quad-tree/
 * 427. 建立四叉树
 * [[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]
 * [[0,0,0,0],[0,0,0,0],[1,1,1,1],[1,1,1,1]]
 */
public class Construct {
    public static void main(String[] args) {
        System.out.println(new Construct().construct(new int[][]{
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}
        }));
    }

    // 时间复杂度：O(2n) => O(n)
    // 空间复杂度：O(5n/4) => O(n)
    // 递归
    public Node construct(int[][] grid) {
        return construct(grid, 0, grid.length - 1, 0, grid.length - 1);
    }

    public Node construct(int[][] grid, int top, int bottom, int left, int right) {
        if (top == bottom) {
            return new Node(grid[top][left] == 1, true);
        }
        if (bottom - 1 == top) {
            // 最后4个元素
            Node topLeft = new Node(grid[top][left] == 1, true);
            Node topRight = new Node(grid[top][right] == 1, true);
            Node bottomLeft = new Node(grid[bottom][left] == 1, true);
            Node bottomRight = new Node(grid[bottom][right] == 1, true);
            if (topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
                // 叶子🍃
                return new Node(topLeft.val, true);
            }
            return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }
        Node topLeft = construct(grid, top, (top + bottom) / 2, left, (left + right) / 2);
        Node topRight = construct(grid, top, (top + bottom) / 2, (left + right) / 2 + 1, right);
        Node bottomLeft = construct(grid, (top + bottom) / 2 + 1, bottom, left, (left + right) / 2);
        Node bottomRight = construct(grid, (top + bottom) / 2 + 1, bottom, (left + right) / 2 + 1, right);
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
            // 儿子都是叶子🍃
            if ((topLeft.val == topRight.val) && (topRight.val == bottomLeft.val) && (bottomLeft.val == bottomRight.val)) {
                // 儿子值都相等
                return new Node(topLeft.val, true);
            }
        }
        // 如果不是叶子🍃，值设置为 true
        // 儿子有一个或多个不是叶子🍃 || 儿子都是叶子🍃，但是值不相同
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
