## 二叉树的前序遍历

<https://leetcode.cn/problems/binary-tree-preorder-traversal/>

### 思路

1. 递归遍历
2. 非递归遍历 => Stack => 利用栈改变元素顺序 => 访问当前节点，先右节点入栈，再左节点入栈
    - 时间复杂度：O(n)
    - 空间复杂度：n为节点个数
        - 最坏情况: O(n) 退化成链表
        - 平均：O(logn)
3. 非递归遍历 => 利用栈模拟递归 => 找到最左子树

### 总结

| 问题行数 | 错误点                                                | 正确写法                                               | 错误原因 |
|------|----------------------------------------------------|----------------------------------------------------|------|
| 11   | while (!stack.isEmpty() &#124;&#124; root != null) | while (!stack.isEmpty() &#124;&#124; node != null) | 大意   |

```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 思路：栈模拟递归 => preorder => 根左右
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }

            node = stack.pop().right;
        }

        return result;
    }

    public List<Integer> preorderTraversalWithRecursion(TreeNode root) {
        // 思路：递归遍历 => preorder => 根左右
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    public List<Integer> preorderTraversalDepth(TreeNode root) {
        // 思路：栈改变节点顺序 => preorder => 根左右
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }
}
```
