## 省份数量

<https://leetcode.cn/problems/number-of-provinces/>

### 思路

1. 邻接矩阵求连通分量 => BFS

### 总结

1. isConnected 是邻接矩阵，不是二维矩阵

| 问题行数 | 错误点                                                | 正确写法                                                                                   | 错误原因                                         |
|------|----------------------------------------------------|----------------------------------------------------------------------------------------|----------------------------------------------|
| 33   | for (int adjacencyNode : isConnected[node])        | for (int adjacencyNode = 0; adjacencyNode < isConnected[node].length; adjacencyNode++) | 错误写法中 adjacencyNode == 0 &#124; 1，需要拿到索引而不是值 |
| 33   | for (int adjacencyNode : isConnected[currentNode]) | for (int adjacencyNode = 0; adjacencyNode < isConnected[node].length; adjacencyNode++) | 索引才是节点。**注意**                                |

```java
class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 || isConnected[0] == null || isConnected[0].length == 0) {
            return 0;
        }

        // marked
        boolean[] visited = new boolean[isConnected.length];
        int connectComponentCount = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                bfs(isConnected, visited, i);
                connectComponentCount++;
            }
        }
        return connectComponentCount;
    }

    private void bfs(int[][] isConnected, boolean[] visited, int start) {
        // queue
        Queue<Integer> queue = new LinkedList<>();

        // offer & marked
        queue.offer(start);
        visited[start] = true;

        // traversal
        while (!queue.isEmpty()) {
            int node = queue.poll();

            // traversal adjacency node
            for (int adjacencyNode = 0; adjacencyNode < isConnected[node].length; adjacencyNode++) {
                if (isConnected[node][adjacencyNode] == 1 && !visited[adjacencyNode]) {
                    // offer & marked
                    queue.offer(adjacencyNode);
                    visited[adjacencyNode] = true;
                }
            }
        }
    }
}
```
