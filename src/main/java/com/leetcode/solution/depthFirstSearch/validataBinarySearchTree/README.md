## 验证二叉搜索树

<https://leetcode.cn/problems/validate-binary-search-tree/>

### 思路

1. 中序遍历是一个有序数组
2. DFS => 分治法 => 查看每一个节点的 left < root < right => 左子树最大值 < root.val && 右子树最小值 > root.val
    1. 分治法返回一个 Result 包含 isBST + min + max
3. 遍历法 => 逐步缩小范围

#### 总结

1. 在比较的时候要注意**左子树最大值**和**右子树最小值**

// TODO: 总结一下返回值是 boolean 的问题
