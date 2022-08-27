# Depth First Search

## 概述

- DFS(Depth First Search) => 深度优先搜索算法 => 递归与回溯，通常隐含了**栈**的实现
    1. 树中 DFS
    2. 一般 DFS 问题 => 一维问题(回溯法) + 二维问题(图)
    3. 大多数一般递归问题也是利用 DFS 求解
- BFS(Breath First Search) => 广度优先搜索算法 => 寻找最小距离或最短路径，通常用**队列**实现

## 一般 DFS 问题模板

```java
public class DepthFirstSearch {
    class Point {
        int num;
        int value;
    }

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph graph, Point start) {
        marked = new boolean[graph.length()];
        dfs(graph, start);
    }

    public void dfs(Graph graph, Point point) {
        marked[point.num] = true;
        count++;

        // graph.adj(point) 表示和 point 相邻的所有节点 周围
        for (Point aroundPoint : graph.adj(point)) {
            if (!marked[aroundPoint.num]) {
                dfs(graph, aroundPoint);
            }
        }
    }

    public int count() {
        return count;
    }
}
```

## 二叉树 DFS 模板

- 遍历法

```java
public class DepthFirstSearchInBinaryTree {
    public static class TreeNode<T> {
        T val;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T rootData) {
            val = rootData;
        }
    }

    public <T> void dfs(TreeNode<T> node) {
        // 需要将具体问题转化 => 具体问题需要做哪些事情
        doSomething(node);
        dfs(node.left);
        dfs(node.right);
    }
}
```


