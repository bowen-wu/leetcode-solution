## 二叉树的层序遍历

<https://leetcode.cn/problems/binary-tree-level-order-traversal/>

### 思路

BFS => 利用队列

1. 如何分层 => 利用 for loop 遍历 queue.size()，一层一层遍历

#### 优化

1. 单一解大小固定，就是 queue.size()
2. queue 添加节点使用 **offer**
