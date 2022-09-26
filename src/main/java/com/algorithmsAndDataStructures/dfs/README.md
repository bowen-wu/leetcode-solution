# Depth First Search

## 概述

- DFS(Depth First Search) => 深度优先搜索算法 => 递归与回溯，通常隐含了**栈**的实现
    1. 树中 DFS
    2. 一般 DFS 问题 => 一维问题(回溯法) + 二维问题(图)
    3. 大多数一般递归问题也是利用 DFS 求解
- BFS(Breath First Search) => 广度优先搜索算法 => 寻找最小距离或最短路径，通常用**队列**实现
- 同时能用 DFS 或 BFS 求解的**图或矩阵问题**，**优先考虑 BFS**

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

## 图论

- 图论（Graph theory），是组合数学分支，和其他数学分支如群论、矩阵论、拓扑学有着密切关系。
- 图是图论的主要研究对象。图是由若干给定的顶点及连接两顶点的边所构成的图形，这种图形通常用来描述某些事物之间的某种特定关系。顶点用于代表事物，连接两顶点的边则用于表示两个事物间具有这种关系。
- 图G(V, E) => 由一系列顶点(Vertices)和边(Edges)连接而成

### 分类

1. 有向图 => 有向边组成的图
    1. 有向边e => e = (u, v) => u 为边的起始顶点，v 为边的终止顶点
    2. 有向无环图(DAG) => 无法从某个顶点出发经过若干条边回到该点的有向图 => 只存在于有向图
2. 无向图
3. 带权图 => 边有权值

### 图的表示

1. 邻接矩阵 => Adjacency Matrix => 容易变为**稀疏矩阵**，开辟空间巨大，浪费内存
    1. 无向图节点 i 的**度** => 第 i 行或第 i 列非 0 个数
    2. 有向图节点 i 的**出度** => 第 i 行(行表示**起点**)非 0 个数
    3. 有向图节点 i 的**入度** => 第 i 列(列表示**终点**)非 0 个数
2. 邻接表 => Adjacency List => 描述**节点与相邻边的映射**，围绕数据结构去建模
    1. 链表
    2. Map<Node, List<Node>>
    3. 出度方便计算，入度需要遍历，或者创建一个**逆邻接表**，用来表示入度的节点

### 图搜索

#### DFS

- 时间复杂度
    1. 邻接表 => O(|V| + |E|) => 和点边都有关系 => 描述**点与相邻边的映射**
    2. 邻接矩阵 => O(|V|^2) => 和点有关，和边无关
- 空间复杂度 => O(|V|)

#### BFS

- 时间复杂度
    1. 邻接表 => O(|V| + |E|) => 和点边都有关系 => 描述**点与相邻边的映射**
    2. 邻接矩阵 => O(|V|^2) => 和点有关，和边无关
- 空间复杂度 => O(|V|)

## 一般 DFS 问题

- 一般深度优先搜索问题 => 一般图 + 矩阵(二维数组)
- DFS + **涂色标记**(避免节点重复访问)
- 搜索节点如何移动

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

### 图中 DFS

```java
public class UndirectedGraph {
    // 邻接表 => key: 当前节点  value: 邻接节点集合
    private final Map<Node, List<Node>> adjacencyList;

    // 是否被访问涂色过
    private final boolean[] marked;

    // 统计连通分量
    private int connectComponentCount;

    public UndirectedGraph(int vertexCount) {
        this.adjacencyList = new HashMap<>();
        this.marked = new boolean[vertexCount];
        this.connectComponentCount = 0;
    }

    // Method
    public void addVertex(Node v) {
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new ArrayList<>());
        }
    }

    public void addEdge(Node u, Node v) {
        if (!adjacencyList.containsKey(u)) {
            addVertex(u);
        }
        if (!adjacencyList.containsKey(v)) {
            addVertex(v);
        }
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    public void printGraph() {
        for (Node key : adjacencyList.keySet()) {
            System.out.println(key.getNo() + ": " + adjacencyList.get(key).stream().map(Node::getNo).map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        }
    }

    // DFS 模板 => 遍历全图
    public void dfsInGraph() {
        Arrays.fill(marked, false);
        for (Node startNode : adjacencyList.keySet()) {
            if (!marked[startNode.getNo()]) {
                helper(startNode);
                connectComponentCount++;
            }
        }
    }

    // DFS 模板 => 以 start 节点为起点在某一连通分量上 DFS
    public void dfsInComponent(Node start) {
        Arrays.fill(marked, false);
        helper(start);
    }

    // DFS helper 函数
    public void helper(Node start) {
        marked[start.getNo()] = true;
        System.out.println("DFS current node: " + start.getNo() + " value: " + start.getValue());

        for (Node adjNode : adjacencyList.get(start)) {
            if (!marked[adjNode.getNo()]) {
                // 没有被访问过
                helper(adjNode);
            }
        }
    }

    public static void main(String[] args) {
        // 0 - 1 - 4
        // |   | /
        // 2 - 3
        UndirectedGraph undirectedGraph = new UndirectedGraph(7);
        Node zero = new Node(0, 1);
        Node one = new Node(1, 2);
        Node two = new Node(2, 3);
        Node three = new Node(3, 4);
        Node four = new Node(4, 5);
        Node five = new Node(5, 6);
        Node six = new Node(6, 7);
        undirectedGraph.addEdge(zero, one);
        undirectedGraph.addEdge(zero, two);
        undirectedGraph.addEdge(one, four);
        undirectedGraph.addEdge(one, three);
        undirectedGraph.addEdge(three, two);
        undirectedGraph.addEdge(three, four);
        undirectedGraph.addEdge(five, six);
        undirectedGraph.printGraph();
        System.out.println("Starting from node 0");
        undirectedGraph.dfsInComponent(zero);
        System.out.println("Starting from node 1");
        undirectedGraph.dfsInComponent(one);
        System.out.println("Traversal graph");
        undirectedGraph.dfsInGraph();
        System.out.println(undirectedGraph.connectComponentCount);
    }

}

class Node {
    int no;
    int value;

    public Node(int no, int value) {
        this.no = no;
        this.value = value;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
```

#### 模板

```java
import java.util.HashMap;

class DFSInGraph {
    public void dfsInGraph(int nodeNum, int[][] edges, int[][] adjacencyMatrix) {
        // 0. 邻接表 => Map<Node, List<Node>> => key: current node  value: adjacency nodes 
        //    邻接矩阵 => int[][] => 索引值代表节点(事物)，(x, y) 的值表示是否相邻
        // 1. check input
        if (adjacencyMatrix == null || adjacencyMatrix.length == 0 || adjacencyMatrix[0] == null || adjacencyMatrix[0].length == 0) {
            return;
        }

        // 2. 边的数组 => 构建邻接表 => 非必须
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i < nodeNum; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        // 3. marked
        boolean[] visited = new boolean[adjacencyMatrix.length];
        int connectComponentCount = 0;

        // 4. traversal adjacency matrix
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (!visited[i]) {
                helper(adjacencyMatrix, adjacencyList, visited, i);
                connectComponentCount++;
            }
        }

        // 4. traversal adjacency list
        for (int node : adjacencyList.keySet()) {
            if (visited[node]) {
                helper(adjacencyMatrix, adjacencyList, visited, node);
                connectComponentCount++;
            }
        }
    }

    private void helper(int[][] adjacencyMatrix, Map<Integer, List<Integer>> adjacencyList, boolean[] visited, int start) {
        // marked
        visited[start] = true;

        // traversal adjacency node in adjacencyMatrix
        for (int i = 0; i < adjacencyMatrix[start].length; i++) {
            if (specialCondition && !visited[i]) {
                helper(adjacencyMatrix, visited, i);
            }
        }

        // traversal adjacency node in adjacencyList
        for (int item : adjacencyList.get(start)) {
            if (specialCondition && !visited[item]) {
                helper(adjacencyMatrix, adjacencyList, visited, item);
            }
        }
    }
}
```

### 二维问题

- 矩阵/网格

#### 分类

1. 迷宫问题 => 二维数组上的回溯法
2. 岛屿问题 => 连通分量

#### 特点

- 二维数组/矩阵问题有区域限制和移动方向限制
- 能移动的方向集合即为邻接节点集合
- 题目有特定条件限制

#### 重点

1. DFS + 涂色标记(标记已访问过的位置)
2. 剪枝

#### 二维空间移动

坐标 (x, y) => 以左下角为原点 => **注意移动边界限制**

- 向上移动 => (x, y + 1)
- 向下移动 => (x, y - 1)
- 向左移动 => (x - 1, y)
- 向右移动 => (x + 1, y)
- 向右上移动 => (x + 1, y + 1)
- 向左上移动 => (x - 1, y + 1)
- 向左下移动 => (x - 1, y - 1)
- 向右下移动 => (x + 1, y - 1)

```
// version1
final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
for (int[] offset : directions) {
    Point next = new Point(cur.x + offset[0], current.y + offset[1]);
}

// version2
int[] dx = {1, 0, -1, 0};
int[] dy = {0, 1, 0, -1};
for (int i = 0; i < 4; i++) {
    Point next = new Point(cur.x + dx[i], cur.y + dy[i]);
}
```

#### 模板

考虑问题

1. specialCondition 是什么？=> 开始能做 DFS 是否有特殊条件?
2. pruning
3. how to move
4. is need backtracking

```java
class DFSInMatrix {
    public void dfsInMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }

        // marked 
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int connectedComponentCount = 0;

        // traversal
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (specialCondition && !visited[i][j]) {
                    dfs(matrix, visited, i, j);
                    connectedComponentCount++;
                }
            }
        }
    }

    private void dfs(int[][] matrix, boolean[][] visited, int x, int y) {
        // pruning => 此处的 pruning 也可以放置在 move 中
        if (condition) {
            return;
        }

        // marked
        visited[x][y] = true;

        // move
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            // 此处可以进行 pruning => if (checkRange(matrix, newX, newY) && !visited[newX][newY] && specialCondition)
            if (checkRange(matrix, newX, newY) && !visited[newX][newY]) {
                dfs(matrix, visited, newX, newY);
            }
        }
    }

    private boolean checkRange(int[][] matrix, int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }
}
```

## 知识点

1. 度 => 图中的节点有几个边就有几个度
2. 连通分量 => 一个图有几个互不相干的部分
3. 在**图**中的邻接矩阵中**索引表示事物**，在**二维矩阵**中**矩阵中的点表示事物**


