## 无向图中连通分量的数目

<https://leetcode.cn/problems/number-of-connected-components-in-an-undirected-graph/>

### 思路

1. 图中求连通分量
2. 构建邻接表

### 思路

| 问题行数 | 错误点                                                                                    | 正确写法                                                                                     | 错误原因 |
|------|----------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------|------|
| 35   | private void dfs(Map<Integer, List<Integer> adjacencyList, int start, boolean visited) | private void dfs(Map<Integer, List<Integer> adjacencyList, int start, boolean[] visited) | 大意   |
| 12   | adjacencyList.put(n, new ArrayList<>())                                                | adjacencyList.put(i, new ArrayList<>())                                                  | 大意   |

```java
class Solution {
    public int countComponents(int n, int[][] edges) {
        // Ideas: construct adjacencyList => get connect component
        // check input
        if (n < 1) {
            return -1;
        }

        // construct adjacencyList
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for (int[] item : edges) {
            int u = item[0];
            int v = item[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        // marked
        boolean[] visited = new boolean[n];
        int connectComponentCount = 0;

        // traversal
        for (int node : adjacencyList.keySet()) {
            if (!visited[node]) {
                dfs(adjacencyList, node, visited);
                connectComponentCount++;
            }
        }
        return connectComponentCount;
    }

    private void dfs(Map<Integer, List<Integer>> adjacencyList, int start, boolean[] visited) {
        // marked
        visited[start] = true;

        // traversal adjacency node
        for (int adjacencyNode : adjacencyList.get(start)) {
            if (!visited[adjacencyNode]) {
                dfs(adjacencyList, adjacencyNode, visited);
            }
        }
    }
}
```
