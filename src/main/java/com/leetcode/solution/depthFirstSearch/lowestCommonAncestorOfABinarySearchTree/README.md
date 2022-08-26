## 二叉搜索树的最近公共祖先

<https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/>

### 思路

分治法

1. 如果 root.val 在 p.val 和 q.val 中间，return root
2. 如果在左子树上，递归在左子树找，如果在右子树，递归在右子树找

### 总结

| 问题行数 | 错误点                                  | 正确写法                                 | 错误原因 |
|------|--------------------------------------|--------------------------------------|------|
| 12   | q.val < root.val && root.val < q.val | q.val < root.val && root.val < p.val | 大意   |

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 思路：比较值就可以知道在哪颗子树上
        if (root == null || p == null || q == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        if (p.val < root.val && root.val < q.val || (q.val < root.val && root.val < p.val)) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return lowestCommonAncestor(root.right, p, q);
    }
}
```
