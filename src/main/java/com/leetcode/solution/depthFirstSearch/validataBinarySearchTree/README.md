## 验证二叉搜索树

<https://leetcode.cn/problems/validate-binary-search-tree/>

### 思路

1. 中序遍历是一个有序数组
2. DFS => 分治法 => 查看每一个节点的 left < root < right => 左子树最大值 < root.val && 右子树最小值 > root.val
    1. 分治法返回一个 Result 包含 isBST + min + max
3. 遍历法 => 逐步缩小范围

### 总结

1. 在比较的时候要注意**左子树最大值**和**右子树最小值**

// TODO: 总结一下返回值是 boolean 的问题

### 理解分治法

0. 问题：验证二叉搜索树
1. 分治法分治问题是什么？
    1. 二叉搜索树性质 => root.left.val < root.val < root.right.val + leftSubtreeMax < root.val + root.val < rightSubtreeMin
    2. 分治法分治问题 => 一颗二叉树是否是 BST
    3. 以 root 为根节点的二叉树是否是 BST
    4. 以 root.left 为根节点的二叉树是否是 BST
    5. 以 root.right 为根节点的二叉树是否是 BST
    6. 以 root.left.left 为根节点的二叉树是否是 BST
    7. 以 root.left.right 为根节点的二叉树是否是 BST
    8. 以 root.right.left 为根节点的二叉树是否是 BST
    9. 以 root.right.right 为根节点的二叉树是否是 BST
3. 分治法子问题和原问题的关系是什么？
    1. 原问题 => 以 root 为根节点的二叉树是否是 BST
    2. 子问题 left => 以 root.left 为根节点的二叉树是否是 BST
    3. 子问题 right => 以 root.right 为根节点的二叉树是否是 BST
    4. 原问题与子问题关系(Combine) => 原问题 == 子问题 left && 子问题 right && 左子树最大值 < root.val && root.val < 右子树最大值
    5. 子问题 left **和** 子问题 right 比原问题少了一个节点 p q => 规模减小