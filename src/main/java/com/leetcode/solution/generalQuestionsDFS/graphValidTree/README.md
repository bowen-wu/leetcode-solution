## 以图判树

<https://leetcode.cn/problems/graph-valid-tree/>

### 思路

1. 树性质 => **边数 == 节点数 - 1** + 连通分量为1

#### 优化

1. 边数 != 节点数 - 1 => 直接返回 false
2. 之后再计算连通分量

### 总结

| 问题行数 | 错误点                    | 正确写法                     | 错误原因 |
|------|------------------------|--------------------------|------|
| 18   | for (int item : edges) | for (int[] item : edges) | 大意   |

```java
class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Ideas: n - 1 == edges.length && connectComponentCount == 1 => bfs
        // check input
        if (n < 1) {
            return false;
        }

        if (n - 1 != edges.length) {
            return false;
        }

        // construct adjacency list
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        // marked
        boolean[] visited = new boolean[n];
        int connectComponentCount = 0;

        // traversal
        for (int node : adjacencyList.keySet()) {
            if (!visited[node]) {
                dfs(adjacencyList, visited, node);
                connectComponentCount++;
            }
        }

        return connectComponentCount == 1;
    }

    private void dfs(Map<Integer, List<Integer>> adjacencyList, boolean[] visited, int node) {
        // marked
        visited[node] = true;

        // traversal adjacency node
        for (int adjacencyNode : adjacencyList.get(node)) {
            if (!visited[adjacencyNode]) {
                dfs(adjacencyList, visited, adjacencyNode);
            }
        }
    }
}
```
