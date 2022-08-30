## 二叉树的中序遍历

<https://leetcode.cn/problems/binary-tree-inorder-traversal/>

### 思路

1. 递归遍历
2. 非递归遍历 => stack => 利用栈模拟递归 => O(n) + O(logn)
    1. 首先对左子树进行迭代
    2. 当前节点为空时进行出栈操作，并访问栈顶节点，将当前节点用右子节点代替

### 总结

| 问题行数 | 错误点                              | 正确写法                 | 错误原因   |
|------|----------------------------------|----------------------|--------|
| 10   | !stack.isEmpty() && node != null | -                    | 大意     |
| 12   | stack.add(node)                  | stack.push(node)     | API 不熟 |
| 30   | result.add(root.value)           | result.add(root.val) | 大意     |

```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 思路：使用栈模拟递归
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode pop = stack.pop();
            result.add(pop.val);
            node = pop.right;
        }
        return result;
    }

    public List<Integer> inorderTraversalWithRecursion(TreeNode root) {
        // 思路：递归 => 左根右
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.addAll(inorderTraversalWithRecursion(root.left));
        result.add(root.val);
        result.addAll(inorderTraversalWithRecursion(root.right));
        return result;
    }
}
```
