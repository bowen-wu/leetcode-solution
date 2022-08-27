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

### 理解分治法

0. 问题：BST 最近公共祖先
1. 分治法分治问题是什么？
    1. 转化问题 => 在左右子树中查找 p q 节点 => 利用 BST 性质可以快速定位是在左子树还是右子树
    2. 进一步理解 => 在树中查找 p q 节点
    3. 分治法分治问题 => 在树中查找 p q 节点
    4. 在以 root 为根节点的二叉树中查找 p q 节点
    5. 在以 root.left 为根节点的二叉树中查找 p q 节点
    6. 在以 root.right 为根节点的二叉树中查找 p q 节点
    7. 在以 root.left.left 为根节点的二叉树中查找 p q 节点
    8. 在以 root.left.right 为根节点的二叉树中查找 p q 节点
    9. 在以 root.right.left 为根节点的二叉树中查找 p q 节点
    10. 在以 root.right.right 为根节点的二叉树中查找 p q 节点
3. 分治法子问题和原问题的关系是什么？
    1. 原问题 => 在以 root 为根节点的二叉树中查找 p q 节点
    2. 子问题 left => 在以 root.left 为根节点的二叉树中查找 p q 节点
    3. 子问题 right => 在以 root.right 为根节点的二叉树中查找 p q 节点
    4. 原问题与子问题关系(Combine)
       1. 原问题 == 子问题 left 
       2. 原问题 == 子问题 right 
       3. 原问题 == 子问题 left + 子问题 right
    5. 子问题 left **或** 子问题 right 比原问题少了一个节点 root => 规模减小
