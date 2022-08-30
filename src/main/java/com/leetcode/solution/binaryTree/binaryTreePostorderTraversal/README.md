## 二叉树的后序遍历

<https://leetcode.cn/problems/binary-tree-postorder-traversal/>

### 思路

1. 递归遍历
2. 迭代遍历 => 使用两个栈
    1. 创建两个栈 s1、s2，将 root 压入 s1 中
    2. 当 s1 不为空时，执行以下操作
        1. 弹出 s1 中元素，并将该节点压入 s2 中
        2. 左子节点不为空，压入 s1
        3. 右子节点不为空，压入 s1
    3. 循环迭代 s2，弹出 s2 中的元素并将其加入结果集中直至 s2 为空
3. 迭代遍历 => stack => 利用栈模拟递归
    1. 难点：并不知道栈顶元素的状态，需要知道该节点的右节点是否被访问过
    2. 解决方法：为节点设置 flag 标识是否被访问过
        ```java
        class NodeWithFlag {
            TreeNode node;
            boolean visited;
       
            public NodeWithFlag(TreeNode node, boolean visited) {
                this.node = node;
                this.visited = visited;
            }
        }
        ```

### 总结

| 问题行数             | 错误点                                  | 正确写法                      | 错误原因                      |
|------------------|--------------------------------------|---------------------------|---------------------------|
| 30               | pulic NodeWithFlag                   | public NodeWithFlag       | 笔误                        |
| 17 & 20          | stack.pop().val / stack.peek().right | stack.pop().getNode()     | 大意                        |
| 5                | List<Integet>                        | List<Integer>             | 笔误                        |
| 16               | stack.peek().isVisited               | stack.peek().isVisited()  | isVisited 是一个方法，不是属性      |
| 第三遍 63           | stack2.push(node.right)              | stack1.push(node.right)   | 笔误                        |
| 第三遍 16           | stack.peek().isVisited               | stack.peek().isVisited()  | isVisited 是一个方法，不是属性      |
| 第三遍 35 & 39 & 43 | public getNode()                     | public TreeNode getNode() | 方法签名包括返回值类型，脱离 IDEA 不会码代码 |
| 第三遍 17 & 20      | stack.pop().val / stack.peek().right | stack.pop().getNode()     | 大意                        |

```java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        // 思路：一个栈，栈 pop 的时候，应该查看该元素是否被访问过，如果被访问过，那么加入 result
        // 		如果没有，拿到右子树去遍历
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<NodeWithFlag> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(new NodeWithFlag(false, node));
                node = node.left;
            }
            if (stack.peek().isVisited()) {
                result.add(stack.pop().getNode().val);
            } else {
                stack.peek().setVisited(true);
                node = stack.peek().getNode().right;
            }
        }
        return result;
    }

    static class NodeWithFlag {
        private boolean visited;
        private TreeNode node;

        public NodeWithFlag(boolean visited, TreeNode node) {
            this.visited = visited;
            this.node = node;
        }

        public TreeNode getNode() {
            return node;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }
    }

    public List<Integer> postorderTraversalTwoStack(TreeNode root) {
        // 思路：两个栈
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
            stack2.push(node);
        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }

        return result;
    }

    public List<Integer> postorderTraversalWithRecursion(TreeNode root) {
        // 思路：递归 => 后续遍历 => 左右根
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(postorderTraversalWithRecursion(root.left));
        result.addAll(postorderTraversalWithRecursion(root.right));
        result.add(root.val);
        return result;
    }
}
```
