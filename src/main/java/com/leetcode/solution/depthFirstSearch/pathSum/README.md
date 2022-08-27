## 路径总和

<https://leetcode.cn/problems/path-sum/>

### 思路

1. 分治法 => 左右子树分别找 target - currentValue，如果是叶子节点，直接比较即可

### 理解分治法

0. 问题：路径总和
1. 分治法分治问题是什么？
    1. 转化问题 => 在二叉树上找到和 target 相等的叶子节点
    2. 分治法分治问题 => 在二叉树上找到和 target 相等的叶子节点
    3. 以 root 为根节点的二叉树上找到和 target 相等的叶子节点
    4. 以 root.left 为根节点的二叉树上找到和 target 相等的叶子节点
    5. 以 root.right 为根节点的二叉树上找到和 target 相等的叶子节点
    6. 以 root.left.left 为根节点的二叉树上找到和 target 相等的叶子节点
    7. 以 root.left.right 为根节点的二叉树上找到和 target 相等的叶子节点
    8. 以 root.right.left 为根节点的二叉树上找到和 target 相等的叶子节点
    9. 以 root.right.right 为根节点的二叉树上找到和 target 相等的叶子节点
2. 分治法子问题和原问题的关系是什么？
    1. 原问题 => 在二叉树上找到和 target 相等的叶子节点
    2. 子问题 left => 以 root.left 为根节点的二叉树上找到和 target 相等的叶子节点
    3. 子问题 right => 以 root.right 为根节点的二叉树上找到和 target 相等的叶子节点
    4. 原问题与子问题关系(Combine) => 原问题 == 子问题 left && 子问题 right
    5. 子问题 left **和** 子问题 right 比原问题少了一个节点 root => 规模减小
