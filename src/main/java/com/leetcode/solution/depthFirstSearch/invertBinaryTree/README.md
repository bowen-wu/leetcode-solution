## 翻转二叉树

<https://leetcode.cn/problems/invert-binary-tree/>

### 思路

1. 分治法
2. 遍历法 => doSomething(node) => 一次翻转
    ```
    public <T> void dfs(TreeNode<T> node) {
        doSomething(node);
        dfs(node.left);
        dfs(node.right);
    }
    ```

### 总结

1. 遍历法 doSomething(node) => 一次翻转

```java
class Solution {
    public TreeNode invertTreeDivideAndConquer(TreeNode root) {
        // 思路：分治法 or 遍历法
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        // 思路：遍历法
        if (root == null) {
            return null;
        }

        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        helper(root.left);
        helper(root.right);
    }
}
```

### 理解分治法

0. 问题：翻转二叉树
1. 分治法分治问题是什么？
    1. 分治法分治问题 => 翻转以 root 为根节点的二叉树
    2. 翻转以 root 为根节点的二叉树
    3. 翻转以 root.left 为根节点的二叉树
    4. 翻转以 root.right 为根节点的二叉树
    5. 翻转以 root.left.left 为根节点的二叉树
    6. 翻转以 root.left.right 为根节点的二叉树
    7. 翻转以 root.right.left 为根节点的二叉树
    8. 翻转以 root.right.right 为根节点的二叉树
2. 分治法子问题和原问题的关系是什么？
    1. 原问题 => 翻转以 root 为根节点的二叉树
    2. 子问题 left => 翻转以 root.left 为根节点的二叉树
    3. 子问题 right => 翻转以 root.right 为根节点的二叉树
    4. 原问题与子问题关系(Combine) => 原问题 == 子问题 left + 子问题 right + root 的一次翻转
    5. 子问题 left 和 子问题 right 比原问题少了一个节点 root => 规模减小
