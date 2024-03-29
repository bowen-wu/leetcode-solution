## 二叉树的层序遍历

<https://leetcode.cn/problems/binary-tree-level-order-traversal/>

### 思路

BFS => 利用队列

1. 如何分层 => 利用 for loop 遍历 queue.size()，一层一层遍历

#### 优化

1. 单一解大小固定，就是 queue.size()
2. queue 添加节点使用 **offer**

### 总结

| 问题行数 | 错误点                     | 正确写法                     | 错误原因 |
|------|-------------------------|--------------------------|------|
| 16   | while (queue.isEmpty()) | while (!queue.isEmpty()) | 大意   |

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (root == null) {
            return result;
        }

        // queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;

        // traversal
        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(list);
        }

        return result;
    }
}
```
