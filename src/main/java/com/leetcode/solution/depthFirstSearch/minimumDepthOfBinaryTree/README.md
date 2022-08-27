## 二叉树的最小深度

<https://leetcode.cn/problems/minimum-depth-of-binary-tree/>

### 思路

1. 分支法 => 考虑如果左子树没有，那高度就以右子树为准
2. 遍历法 => 叶子节点的时候才会更新 depth

### 总结

| 问题行数    | 错误点   | 正确写法   | 错误原因 |
|---------|-------|--------|------|
| 13      | reurn | return | 大意   |
| 38 & 39 | help  | helper | 大意   |

```java
class Solution {
    public int minDepth(TreeNode root) {
        // 思路：分支法 or 遍历法
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    private int depth;

    public int minDepthTraversal(TreeNode root) {
        if (root == null) {
            return 0;
        }

        depth = Integer.MAX_VALUE;
        helper(root, 1);
        return depth;
    }

    private void helper(TreeNode root, int currentDepth) {
        if (root == null) {
            return;
        }

        // 何时更新 depth => 叶子节点的时候更新 depth
        if (root.left == null && root.right == null && currentDepth < depth) {
            depth = currentDepth;
        }

        helper(root.left, currentDepth + 1);
        helper(root.right, currentDepth + 1);
    }
}
```

### 理解分治法

0. 问题：二叉树的最小深度
1. 分治法分治问题是什么？
    1. 分治法分治问题 => 二叉树的最小深度
    2. 以 root 为根节点的二叉树的最小深度
    3. 以 root.left 为根节点的二叉树的最小深度
    4. 以 root.right 为根节点的二叉树的最小深度
    5. 以 root.left.left 为根节点的二叉树的最小深度
    6. 以 root.left.right 为根节点的二叉树的最小深度
    7. 以 root.right.left 为根节点的二叉树的最小深度
    8. 以 root.right.right 为根节点的二叉树的最小深度
2. 分治法子问题和原问题的关系是什么？
    1. 原问题 => 二叉树的最小深度
    2. 子问题 left =>
        1. root.left != null => 以 root.left 为根节点的二叉树的最小深度
        2. root.left == null => 无
    3. 子问题 right =>
        1. root.right != null => 以 root.right 为根节点的二叉树的最小深度
        2. root.right == null => 无
    4. 原问题与子问题关系(Combine) =>
        1. root.left == null => 原问题 == 子问题 right + 1
        2. root.right == null => 原问题 == 子问题 left + 1
        3. root.left != null && root.right != null => 原问题 = Math.min(子问题 left, 子问题 right) + 1
    6. 子问题 left **和** 子问题 right 比原问题少了一个节点 root => 规模减小
