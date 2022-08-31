## 平衡二叉树

<https://leetcode.cn/problems/balanced-binary-tree/>

### 思路

1. 分治法 => 左子树是平衡的，右子树也是平衡的，但是也要比较左右子树得高度差 => 根据左右子树平衡推不出树是平衡的
2. 遍历法 =>

#### 优化

1. 分治法的 combine，除了查看左右子树是否平衡，还要看当前树是否平衡 => 自顶向下
2. getHeight 会被重复调用
3. DFS => 从叶子节点开始，计算 h<sub>node</sub>，如果平衡返回高度，如果不平衡，返回-1
4. getHeight 具有两个功能，一个是计算高度，一个是判断是否平衡，如果不平衡，返回 -1
5. 自底向上

### 总结

| 问题行数 | 错误点                               | 正确写法                               | 错误原因   |
|------|-----------------------------------|------------------------------------|--------|
| 11   | Math.abs(leftHeight, rightHeight) | Math.abs(leftHeight - rightHeight) | API 不熟 |

```java
class Solution {
    public boolean isBalancedDivideAndConquer(TreeNode root) {
        // 思路：分治法 => 求得左右子树的高度，=> left subTree is balanced & right subTree is balanced & leftHeight rightHeight < 1
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left) + 1;
        int rightHeight = getHeight(root.right) + 1;

        return isBalancedDivideAndConquer(root.left) && isBalancedDivideAndConquer(root.right) && Math.abs(leftHeight - rightHeight) <= 1;
    }

    public boolean isBalanced(TreeNode root) {
        // 遍历法 => 从深度开始计算，如果是 -1，就一直返回来
        if (root == null) {
            return true;
        }

        int depth = getDepth(root);
        return depth != -1;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getDepth(node.left);
        int right = getDepth(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
```

### 理解分治法

0. 问题：判断一棵树是否平衡
1. 分治法分治问题是什么？
    1. 平衡二叉树定义 => 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1
    2. 转化问题 => 判断一棵树每个节点的左右两个子树的高度差的绝对值不超过 1
    3. 分治法分治问题 => 判断一棵树每个节点的左右两个子树的高度差的绝对值不超过 1
    4. 以 root 为根节点的二叉树每个节点的左右两个子树的高度差的绝对值不超过 1
    5. 以 root.left 为根节点的二叉树每个节点的左右两个子树的高度差的绝对值不超过 1
    6. 以 root.right 为根节点的二叉树每个节点的左右两个子树的高度差的绝对值不超过 1
    7. 以 root.left.left 为根节点的二叉树每个节点的左右两个子树的高度差的绝对值不超过 1
    8. 以 root.left.right 为根节点的二叉树每个节点的左右两个子树的高度差的绝对值不超过 1
2. 分治法子问题和原问题的关系是什么？
    1. 原问题 => 判断以 root 为根节点的二叉树的每个节点左右两个子树的高度差的绝对值不超过 1
    2. 子问题 left => 判断以 root.left 为根节点的二叉树的每个节点左右两个子树的高度差的绝对值不超过 1
    3. 子问题 right => 判断以 root.right 为根节点的二叉树的每个节点左右两个子树的高度差的绝对值不超过 1
    4. 原问题与子问题关系(Combine) => 原问题 == 子问题 left && 子问题 right && && Math.abs(leftSubtree - rightSubTree) <= 1
    5. 子问题 left 和 子问题 right 比原问题少了一个节点 root => 规模减小
