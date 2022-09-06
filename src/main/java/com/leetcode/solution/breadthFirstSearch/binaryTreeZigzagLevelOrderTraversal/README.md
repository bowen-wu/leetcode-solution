## 二叉树的锯齿形层序遍历

<https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/>

### 思路

1. BFS => queue => zigzag => result.size() % 2 == 0 ? list.add(node.val) : list.add(0, node.val)
