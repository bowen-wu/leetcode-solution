## 二叉树的最近公共祖先

<https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/>

### 思路

分治法 => 在左右子树上找 p 和 q 节点 => 找到了返回该节点

1. p 和 q 在左右子树上 => return root
2. p 和 q 在同一颗子树上 => 返回先遍历到的节点即可

### 总结

### 理解分治法

0. 问题：二叉树的最近公共祖先
1. 分治法分治问题是什么？
    1. 转化问题 => 在左右子树中查找 p q 节点
    2. 进一步理解 => 在树中查找 p q 节点
    3. 分治法分治问题 => 在树中查找 p q 节点
    4. 在以 root 为根节点的二叉树中查找 p q 节点
    5. 在以 root.left 为根节点的二叉树中查找 p q 节点
    6. 在以 root.right 为根节点的二叉树中查找 p q 节点
    7. 在以 root.left.left 为根节点的二叉树中查找 p q 节点
    8. 在以 root.left.right 为根节点的二叉树中查找 p q 节点
    9. 在以 root.right.left 为根节点的二叉树中查找 p q 节点
    10. 在以 root.right.right 为根节点的二叉树中查找 p q 节点
2. 分治法子问题和原问题的关系是什么？
    1. 原问题 => 在以 root 为根节点的二叉树中查找 p q 节点
    2. 子问题 left => 在以 root.left 为根节点的二叉树中查找 p q 节点
    3. 子问题 right => 在以 root.right 为根节点的二叉树中查找 p q 节点
    4. 原问题与子问题关系(Combine)
        1. 原问题 == 子问题 left
        2. 原问题 == 子问题 right
        3. 原问题 == 子问题 left + 子问题 right
    5. 子问题 left **或** 子问题 right 比原问题少了一个节点 root => 规模减小
