## 对称二叉树

<https://leetcode.cn/problems/symmetric-tree/>

### 思路

1. 分治法 => 左右两颗子树对称不能推出树对称，所以不能使用分治法
2. 遍历法 => 何时更新全局变量 => 不对称的时候

#### 优化

1. 可以不使用全局变量，helper 函数带有返回值 boolean

### 总结

| 问题行数 | 错误点        | 正确写法        | 错误原因 |
|------|------------|-------------|------|
| 20   | right.righ | right.right | 大意   |

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // 思路：分治法 => 轴对称 => 左与右对称，继续深入比较
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
```

### 理解分治法

0. 问题：二叉树是否对称
1. 分治法分治问题是什么？
    1. 转化问题 => p 和 q 两棵树是否对称
    2. 分治法分治问题 => p 和 q 两棵二叉树是否对称
    3. 以 p 为根节点的二叉树和以 q 为根节点的二叉树是否对称
    4. 以 p.left 为根节点的二叉树和以 q.right 为根节点的二叉树是否对称
    5. 以 p.right 为根节点的二叉树和以 q.left 为根节点的二叉树是否对称
    6. 以 p.left.left 为根节点的二叉树和以 q.right.right 为根节点的二叉树是否对称
    7. 以 p.left.right 为根节点的二叉树和以 q.right.left 为根节点的二叉树是否对称
    8. 以 p.right.left 为根节点的二叉树和以 q.left.right 为根节点的二叉树是否对称
    9. 以 p.right.right 为根节点的二叉树和以 q.left.left 为根节点的二叉树是否对称
2. 分治法子问题和原问题的关系是什么？
    1. 原问题 => 以 p 为根节点的二叉树和以 q 为根节点的二叉树是否对称
    2. 子问题 left => 以 p.left 为根节点的二叉树和以 q.right 为根节点的二叉树是否对称
    3. 子问题 right => 以 p.right 为根节点的二叉树和以 q.left 为根节点的二叉树是否对称
    4. 原问题与子问题关系(Combine) => 原问题 == 子问题 left && 子问题 right && pValue == qValue
    5. 子问题 left **和** 子问题 right 比原问题少了一个节点 p q => 规模减小
