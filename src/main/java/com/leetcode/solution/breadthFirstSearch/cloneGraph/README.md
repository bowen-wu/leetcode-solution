## 克隆图

<https://leetcode.cn/problems/clone-graph/>

### 思路

1. BFS 遍历图
2. 如果命中缓存，将该节点加入 neighbor 中 => Map<Node, Node> => oldNode -> newNode
3. 遇到新节点创建 + 加入 neighbor + 更新缓存
