## 二叉树的最近公共祖先

<https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/>

### 思路

分治法 => 在左右子树上找 p 和 q 节点 => 找到了返回该节点

1. p 和 q 在左右子树上 => return root
2. p 和 q 在同一颗子树上 => 返回先遍历到的节点即可
