## 克隆图

<https://leetcode.cn/problems/clone-graph/>

### 思路

1. dfs 遍历图
2. 如果命中缓存，直接返回 => Map<Node, Node> => oldNode -> newNode
3. 遇到新节点复制
4. 新节点邻居节点 => dfs

### 总结

| 问题行数 | 错误点                                      | 正确写法                                      | 错误原因    |
|------|------------------------------------------|-------------------------------------------|---------|
| 23   | for (int adjacencyNode : node.neighbors) | for (Node adjacencyNode : node.neighbors) | 类型写错。大意 |
| 24   | dfs(adjacencyNode)                       | dfs(adjacencyNode, map)                   | 大意      |
| 25   | newNode.neighbors.add()                  | newNode.neighbors.add(newAdjacencyNode)   | 大意      |

```java
class Solution {
    public Node cloneGraph(Node node) {
        // Ideas: dfs
        // check input
        if (node == null) {
            return null;
        }

        // Map => old node -> new node
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        // hit cache
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for (Node adjacencyNode : node.neighbors) {
            Node newAdjacencyNode = dfs(adjacencyNode, map);
            newNode.neighbors.add(newAdjacencyNode);
        }

        return newNode;
    }
}
```
