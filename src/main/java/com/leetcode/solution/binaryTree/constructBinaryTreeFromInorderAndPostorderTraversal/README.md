## 从中序与后序遍历序列构造二叉树

<https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/>

### 思路

1. 后序最后一个确定根节点
2. 中序区分左右
3. left
    1. inorder => [inStart, rootIndex - 1] => 个数：rootIndex - inStart
    2. postorder => [postStart, postStart + rootIndex - inStart - 1]
4. right
    1. inorder => [rootIndex + 1, inEnd]
    2. postorder => [postStart + rootIndex - inStart, postEnd - 1]

### 总结

| 问题行数 | 错误点           | 正确写法            | 错误原因 |
|------|---------------|-----------------|------|
| 5    | order == null | inorder == null | 笔误   |

```java
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 思路：后续确定根节点，中序分左右 => 中序分左右之后，拿到左右子树个数，之后继续构造
        // 		使用 Map 存储中序 value -> index
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueIndexMap.put(inorder[i], i);
        }

        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, valueIndexMap);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> valueIndexMap) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postEnd]);
        Integer nodeIndex = valueIndexMap.get(postorder[postEnd]);
        if (nodeIndex == null) {
            return null;
        }
        node.left = helper(inorder, inStart, nodeIndex - 1, postorder, postStart, postStart + nodeIndex - inStart - 1, valueIndexMap);
        node.right = helper(inorder, nodeIndex + 1, inEnd, postorder, postStart + nodeIndex - inStart, postEnd - 1, valueIndexMap);
        return node;
    }
}
```
