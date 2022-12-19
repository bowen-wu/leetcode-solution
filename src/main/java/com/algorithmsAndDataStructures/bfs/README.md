## 概述

- 从根开始(图则选择一些任意节点作为根)并且在移动到下一级邻居之前首先探索邻居节点
- 以当前节点为圆心画圆，层层递进，将覆盖的节点放入**队列**
- 不需要递归，利用**队列**解决
- 图 BFS 需要涂色

## 场景

- 树的层序遍历
- 图搜索/遍历
- 拓扑排序
- 求最短路径
- 能用 BFS 速求的题目就不要用 DFS

## 二叉树 BFS 模板

```java
import java.util.ArrayList;

public class BinaryTreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Ideas: BFS => queue => for loop for every level
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (root == null) {
            return result;
        }

        // Queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // number of every level
        int size;

        // traversal
        while (!queue.isEmpty()) {
            // single result of every level
            List<Integer> list = new ArrayList<>();
            size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(list);
        }

        return result;
    }
}
```

## 图中 BFS

```java
public class BFSInGraph {
    public void bfsInGraph(int nodeNum, int[] edges, int[][] adjacencyMatrix) {
        // check input
        if (nodeNum < 1 || adjacencyMatrix == null || adjacencyMatrix.length == 0 || adjacencyMatrix[0] == null || adjacencyMatrix[0].length == 0) {
            return;
        }

        // construct adjacencyList => Map<Node, List<Node>> => node -> adjacency node
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

        // marked
        boolean[] visited = new boolean[nodeNum];
        boolean[] visited = new boolean[adjacencyMatrix.length];
        int connectComponentCount = 0;

        // traversal in adjacencyList
        for (int node : adjacencyList.keySet()) {
            if (specialCondition && !visited[node]) {
                bfs(adjacencyList, adjacencyMatrix, visited, node);
                connectComponentCount++;
            }
        }

        // traversal in adjacencyMatrix
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (specialCondition && !visited[i]) {
                bfs(adjacencyList, adjacencyMatrix, visited, i);
                connectComponentCount++;
            }
        }
    }

    private void bfs(Map<Integer, List<Integer>> adjacencyList, int[][] adjacencyMatrix, boolean[] visited, int start) {
        // queue
        Queue<Integer> queue = new LinkedList<>();

        // offer & marked
        queue.offer(start);
        visited[start] = true;

        // traversal in adjacencyList
        while (!queue.isEmpty()) {
            int node = queue.poll();

            // traversal adjacency node
            for (int adjacencyNode : adjacenList.get(node)) {
                if (specialCondition && !visited[adjacencyNode]) {
                    // offer & marked
                    queue.offer(adjacencyNode);
                    visited[adjacencyNode] = true;
                }
            }
        }

        // traversal in adjacencyMatrix
        while (!queue.isEmpty()) {
            int node = queue.poll();

            // traversal adjacency node
            for (int i = 0; i < adjacencyMatrix[node].length; i++) {
                if (specialCondition && !visited[i]) {
                    // offer & marked
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
```

## 二维问题 BFS

```java
public class BFSInMatrix {
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, -1, 0, 1};

    public void bfsInMatrix(int[][] matrix) {
        // 时间复杂度：O(m * n)
        // 空间复杂度：O(m * n)
        // check input
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }

        // marked
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int connectComponentCount = 0;

        // traversal
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (specialCondition && !visited[i][j]) {
                    bfs(matrix, visited, i, j);
                    connectComponentCount++;
                }
            }
        }
    }

    public void bfs(int[][] matrix, boolean[][] visited, int x, int y) {
        // queue
        Queue<Point> queue = new LinkedList<>();

        // offer & marked
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        // move
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];
                if (checkRange(matrix, newX, newY) && !visited[newX][newY] && specialContition) {
                    // offer & marked
                    queue.offer(new Point(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }

    private boolean checkRange(int[][] matrix, int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
```

## 拓扑排序 Topological Sort

对于一个有向无环图(DAG)进行拓扑排序，是将 DAG 中所有顶点排成一个线性序列，使得对图中任意一条边(u, v)，u 在线性序列中出现在 v 之前。通常这样的线性序列成为满足拓扑次序(Topological Order)
的序列，简称拓扑序列

1. 必须是有向无环图(DAG)才有拓扑排序
2. 若存在一条从顶点A到顶点B的路径，那么在序列中顶点A出现在顶点B之前

- 拓扑排序通常用来**排序具有依赖关系的任务**
- 拓扑排序并不唯一

### 卡恩算法

1. 遍历所有图节点，把入度为0的节点入队
2. 当队列不为空时，取出一个节点 v 放入序列
3. 将与 v 相邻的节点入度减1，然后把减1后入度为0的节点入队
4. 重复 2，3 步，直到队列为空，返回序列即为拓扑序列
5. 如果**拓扑序列中节点数量少于图节点数量**则说明该**有向图存在环**

#### 要点

1. 计算每个节点的入度，用 map 维护
2. 将入度为0的节点均加入队列
3. while 循环队列，取出节点
4. 得到节点的邻接节点，将所有邻接节点的入度减1，并更新 map
5. 若邻接节点更新后的入度为0，加入队列

#### 实现

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DirectedGraph {
    private final List<DirectedGraphNode> graphNodes;

    public DirectedGraph(List<DirectedGraphNode> graphNodes) {
        this.graphNodes = graphNodes;
    }

    public List<DirectedGraphNode> topologicalSort() {
        // 1. 计算每个图节点的入度，用 map 维护，key：当前图节点，value：入度值
        Map<DirectedGraphNode, Integer> inDegreeMap = new HashMap<>();
        for (DirectedGraphNode node : graphNodes) {
            for (DirectedGraphNode adjacencyNode : node.getAdjacencyNodes()) {
                inDegreeMap.merge(adjacencyNode, 1, Integer::sum);
            }
        }

        // 2. 将入度为 0 的节点入队
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graphNodes) {
            if (!inDegreeMap.containsKey(node)) {
                queue.offer(node);
            }
        }


        // 3. BFS
        List<DirectedGraphNode> topologicalList = new ArrayList<>();
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            topologicalList.add(node);

            // 得到节点的邻接节点，将所有邻接节点的入度减1，并更新 map => 若邻接节点更新后的入度为0，加入队列
            for (DirectedGraphNode adjacencyNode : node.getAdjacencyNodes()) {
                int newInDegree = inDegreeMap.get(adjacencyNode) - 1;
                inDegreeMap.put(adjacencyNode, newInDegree);
                if (newInDegree == 0) {
                    queue.offer(adjacencyNode);
                }
            }
        }

        return topologicalList;
    }

    public static void main(String[] args) {
        DirectedGraphNode node5 = new DirectedGraphNode(5);
        DirectedGraphNode node2 = new DirectedGraphNode(2, Collections.singletonList(node5));
        DirectedGraphNode node3 = new DirectedGraphNode(3, Collections.singletonList(node5));
        DirectedGraphNode node6 = new DirectedGraphNode(6, Collections.singletonList(node5));
        DirectedGraphNode node4 = new DirectedGraphNode(4, Arrays.asList(node5, node6));
        DirectedGraphNode node1 = new DirectedGraphNode(1, Arrays.asList(node2, node3, node4));
        List<DirectedGraphNode> graphNodes = Arrays.asList(node1, node2, node3, node4, node5, node6);
        DirectedGraph directedGraph = new DirectedGraph(graphNodes);
        List<DirectedGraphNode> directedGraphNodes = directedGraph.topologicalSort();
        directedGraphNodes.forEach(node -> System.out.println(node.getNo()));
    }
}
```

#### 模板

```java
public class TopologicalSort {
    public List<Integer> topologicalSort(int nodeNum, int[] edges, int[][] adjacencyMatrix) {
        // check input
        if (nodeNum < 1 || adjacencyMatrix == null || adjacencyMatrix.length == 0 || adjacencyMatrix[0] == null || adjacencyMatrix[0].length == 0) {
            return null;
        }

        // 1. construct adjacency list
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

        // 2. calculate in degree -> int -> int => adjacency list
        int[] inDegree = new int[nodeNum];
        for (int node : adjacency.keySet()) {
            inDegree[node] = adjacency.get(node).size();
        }

        // 2. calculate in degree -> int -> int => adjacency matrix
        int[] inDegree = new int[adjacencyMatrix.length];
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            int currentInDegree = 0;
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    currentInDegree++;
                }
            }
            inDegree[i] = currentInDegree;
        }

        // 3. in degree is zero push queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 4. BFS
        List<Integer> topologicalList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topologicalList.add(node);

            // 5. adjacency node in degree subtract 1 => adjacency list
            for (int adjacencyNode : adjacencyList.get(node)) {
                int newIndegree = inDegree[adjacencyNode] - 1;
                inDegree[adjacencyNode] = newIndegree;
                if (newIndegree == 0) {
                    queue.offer(adjacencyNode);
                }
            }

            // 5. adjacency node in degree subtract 1 => adjacency matrix 
            for (int i = 0; i < adjacencyMatrix[node].length; i++) {
                if (adjacencyMatrix[node][i] == 1) {
                    int newInDegree = inDegree[i] - 1;
                    inDegree[i] = newIndegree;
                    if (newIndegree == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        return topologicalList;
    }
}
```

## 最短路径相关问题 BFS

- 由于 BFS 层层遍历的特点，可以解决部分最短路径问题

1. 二叉树最小深度
2. 走出迷宫的最短路径

### 双向 BFS

- 单向 BFS 的局限 => 搜索空间可能巨大
- 分别从起点和终点出发进行 BFS，看是否能够相遇
- 需要维护两个队列，用数组或哈希表记录搜索状态
- 当某个节点被两个 BFS 同时标记则搜索结束
- 尽可能让两个方向搜索平均 => **Q1 > Q2 时，只移动 Q2**
