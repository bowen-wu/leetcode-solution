## 二叉树中的最大路径和

<https://leetcode.cn/problems/binary-tree-maximum-path-sum/>

### 思路

对于树中任意节点，其路径情况为：

1. 只有此根节点
2. 左子树
3. 右子树
4. 左子树 + 根节点
5. 右子树 + 根节点
6. 左子树 + 根节点 + 右子树

在做 DFS 时，可以拿到最大的 1、4、5 三种情况 => 分治法

1. 分治的问题 => 最大路径和
2. 原问题和子问题的关系 => 新增一个或多个节点

那么2、3、6三种情况需使用一个全局变量在遍历节点时记录

#### 优化

1. 单选左子树或右子树在以左子树或右子树为根节点的时候已经计算过了，所以无需比较 2、3 情况
2. 左右子树可以和0取最大值，如果是负数，则不需要加

### 总结

1. 注意全局变量的初始值
2. 注意如果 root == null 的返回值

| 问题行数 | 错误点                                     | 正确写法                                    | 错误原因                                                                                                                                                          |
|------|-----------------------------------------|-----------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 2    | Integet.MIN_VALUE                       | Integer.MIN_VALUE                       | 笔误                                                                                                                                                            |
| 16   | return Math.max(pathSum, helper(root)); | return Math.max(helper(root), pathSum); | 先计算 helper 更新 pathSum，之后才能和 pathSum 比较。[Argument Lists are Evaluated Left-to-Right](https://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.7.4) |

```java
class Solution {
    private int pathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // Ideas: 对于每一个节点 root：
        //			1. 只选择 root
        //			2. 选择 root.left
        //			3. 选择 root.right
        //			4. 选择 root + root.left
        //			5. 选择 root + root.right
        //			6. 选择 root.left + root + root.right
        if (root == null) {
            return 0;
        }

        return Math.max(helper(root), pathSum);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        if (left + root.val + right > pathSum) {
            pathSum = left + root.val + right;
        }

        return Math.max(Math.max(left + root.val, right + root.val), root.val);
    }
}
```

### 理解分治法

0. 原问题：二叉树中的最大路径和
1. 分治法分治问题是什么？
    1. 分治法分治问题 =>
2. 分治法子问题和原问题的关系是什么？
    1. 原问题 =>
    2. 子问题 left =>
    3. 子问题 right =>
    4. 原问题与子问题关系(Combine) =>


