## 克隆图

<https://leetcode.cn/problems/clone-graph/>

### 思路

1. BFS 遍历图
2. 如果命中缓存，将该节点加入 neighbor 中 => Map<Node, Node> => oldNode -> newNode
3. 遇到新节点创建 + 加入 neighbor + 更新缓存

### 总结

| 问题行数 | 错误点                                         | 正确写法                                    | 错误原因 |
|------|---------------------------------------------|-----------------------------------------|------|
| 24   | for (Node neighbor : currentNode.neighbors) | for (Node neighbor : oldNode.neighbors) | 大意   |

```java
class Solution {
    public Node cloneGraph(Node node) {
        // Ideas: BFS        
        // check input
        if (node == null) {
            return null;
        }

        // map => oldNode -> newNode
        Map<Node, Node> map = new HashMap<>();

        // queue
        Queue<Node> queue = new LinkedList<>();

        // offer & mark
        queue.offer(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        // traversal
        while (!queue.isEmpty()) {
            Node oldNode = queue.poll();
            Node currentNode = map.get(oldNode);
            for (Node neighbor : oldNode.neighbors) {
                if (map.containsKey(neighbor)) {
                    currentNode.neighbors.add(map.get(neighbor));
                } else {
                    // offer & mark
                    queue.offer(neighbor);
                    Node newNeighbor = new Node(neighbor.val);
                    map.put(neighbor, newNeighbor);
                    currentNode.neighbors.add(newNeighbor);
                }
            }
        }

        return newNode;
    }
}
```
