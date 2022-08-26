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
