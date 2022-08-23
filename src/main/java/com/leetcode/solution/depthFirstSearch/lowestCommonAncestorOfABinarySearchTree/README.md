## 二叉搜索树的最近公共祖先

<https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/>

### 思路

分治法

1. 如果 root.val 在 p.val 和 q.val 中间，return root
2. 如果在左子树上，递归在左子树找，如果在右子树，递归在右子树找
