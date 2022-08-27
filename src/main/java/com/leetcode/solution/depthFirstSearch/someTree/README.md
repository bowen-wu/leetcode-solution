## 相同的树

<https://leetcode.cn/problems/same-tree/>

### 思路

1. 递归比较 => 分治法
    1. Divide => 左子树 + 右子树
    2. Combine => 左子树相同 && 右子树相同 && 当前节点相同

### 理解分治法

0. 问题：两棵树是否相同
1. 分治法分治问题是什么？
    1. 分治法分治问题 => p 和 q 两棵二叉树是否相同
    2. 以 p 为根节点的二叉树和以 q 为根节点的二叉树是否相同
    3. 以 p.left 为根节点的二叉树和以 q.left 为根节点的二叉树是否相同
    4. 以 p.right 为根节点的二叉树和以 q.right 为根节点的二叉树是否相同
    5. 以 p.left.left 为根节点的二叉树和以 q.left.left 为根节点的二叉树是否相同
    6. 以 p.left.right 为根节点的二叉树和以 q.left.right 为根节点的二叉树是否相同
    7. 以 p.right.left 为根节点的二叉树和以 q.right.left 为根节点的二叉树是否相同
    8. 以 p.right.right 为根节点的二叉树和以 q.right.right 为根节点的二叉树是否相同
2. 分治法子问题和原问题的关系是什么？
    1. 原问题 => 以 p 为根节点的二叉树和以 q 为根节点的二叉树是否相同
    2. 子问题 left => 以 p.left 为根节点的二叉树和以 q.left 为根节点的二叉树是否相同
    3. 子问题 right => 以 p.right 为根节点的二叉树和以 q.right 为根节点的二叉树是否相同
    4. 原问题与子问题关系(Combine) => 原问题 == 子问题 left && 子问题 right && pValue == qValue
    5. 子问题 left **和** 子问题 right 比原问题少了一个节点 p q => 规模减小
