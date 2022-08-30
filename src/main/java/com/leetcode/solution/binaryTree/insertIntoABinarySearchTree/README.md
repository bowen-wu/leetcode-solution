## 二叉搜索树中的插入操作

<https://leetcode.cn/problems/insert-into-a-binary-search-tree/>

### 思路

1. 单指针，val 与根节点进行比较，如果根节点的值大于 val，则指针指向左边，否则指针指向右边
2. 如果左子树或者右子树为 null，则插入并返回
3. 如果是空树，直接返回以 val 为根节点的树

### 总结

1. 思路问题，思路需要总结，没有想好思路

| 问题行数 | 错误点         | 正确写法                     | 错误原因                                    |
|------|-------------|--------------------------|-----------------------------------------|
| 7    | return null | return new TreeNode(val) | 当 root == null 时，应该返回以 val 为根节点的树。没考虑全面 |

```java
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 思路：二分
        // 		1. 如果是空树 => 直接返回以 val 为根节点的树
        // 		2. 二分遍历的时候，如果 left | right 是 null，则直接插入并返回
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode node = root;
        while (node != null) {
            if (node.val == val) {
                return null;
            }
            if (node.val > val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return root;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                }
                node = node.right;
            }
        }
        return root;
    }
}
```
