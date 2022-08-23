## 二叉树的最小深度

<https://leetcode.cn/problems/minimum-depth-of-binary-tree/>

### 思路

1. 分支法 => 考虑如果左子树没有，那高度就以右子树为准
2. 遍历法 => 叶子节点的时候才会更新 depth
