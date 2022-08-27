## 二叉树的最大深度

<https://leetcode.cn/problems/maximum-depth-of-binary-tree/>

### 思路

1. 分治法
2. 遍历法 => 当前深度 > depth 时更新 depth

### 总结

| 问题行数    | 错误点                           | 正确写法                              | 错误原因 |
|---------|-------------------------------|-----------------------------------|------|
| 34      | return Math(left, right) + 1; | return Math.max(left, right) + 1; | 笔误   |
| 16 - 18 | 没有判断 root == null 的情况         | -                                 | 判空   |

```java
class Solution {
    private int depth;

    public int maxDepth(TreeNode root) {
        // 思路：遍历法
        depth = 0;
        if (root == null) {
            return depth;
        }

        helper(root, 1);
        return depth;
    }

    private void helper(TreeNode root, int currentDepth) {
        if (root == null) {
            return;
        }
        if (currentDepth > depth) {
            depth = currentDepth;
        }
        helper(root.left, currentDepth + 1);
        helper(root.right, currentDepth + 1);
    }

    public int maxDepth(TreeNode root) {
        // 思路：分治法 or 遍历法
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
```

### 理解分治法

0. 问题：二叉树的最大深度
1. 分治法分治问题是什么？
    1. 分治法分治问题 => 二叉树的最大深度
    2. 以 root 为根节点的二叉树的最大深度
    3. 以 root.left 为根节点的二叉树的最大深度
    4. 以 root.right 为根节点的二叉树的最大深度
    5. 以 root.left.left 为根节点的二叉树的最大深度
    6. 以 root.left.right 为根节点的二叉树的最大深度
    7. 以 root.right.left 为根节点的二叉树的最大深度
    8. 以 root.right.right 为根节点的二叉树的最大深度
2. 分治法子问题和原问题的关系是什么？
    1. 原问题 => 二叉树的最大深度
    2. 子问题 left => 以 root.left 为根节点的二叉树的最大深度
    3. 子问题 right => 以 root.right 为根节点的二叉树的最大深度
    4. 原问题与子问题关系(Combine) => 原问题 == Math.max(子问题 left, 子问题 right) + 1
    5. 子问题 left **和** 子问题 right 比原问题少了一个节点 root => 规模减小
