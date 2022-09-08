## 以图判树

<https://leetcode.cn/problems/graph-valid-tree/>

### 思路

1. BFS
2. 树性质 => **边数 == 节点数 - 1** + 连通分量为1

#### 优化

1. 边数 != 节点数 - 1 => 直接返回 false
2. 之后再计算连通分量
