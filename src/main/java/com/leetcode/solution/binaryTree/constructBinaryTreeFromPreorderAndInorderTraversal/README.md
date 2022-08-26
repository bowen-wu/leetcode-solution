## 从前序与中序遍历序列构造二叉树

<https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/>

### 思路

1. 前序确定根节点，中序划定左右
2. 左 => 前序确定根节点，中序划定左右
3. 右 => 前序确定根节点，中序划定左右
4. **使用 Map cache inorder**
5. 左 ->
    1. preorder => [preStart + 1, preStart + 1 + 个数 - 1]
    2. inorder => [inStart, i - 1] => 个数: i - 1 - inStart + 1 = i - inStart
6. 右 ->
    1. preorder => [preStart + 1 + 个数, preEnd]
    2. inorder => [i + 1, inEnd]

### 总结

| 问题行数 | 错误点                                           | 正确写法                                              | 错误原因                            |
|------|-----------------------------------------------|---------------------------------------------------|---------------------------------|
| 21   | TreeNode root = preorder[preStart];           | int rootValue = preorder[preStart]                | preorder 是一个 int[]，笔误           |
| 22   | int rootIndex = valueIndexMap.get(rootValue); | Integer rootIndex = valueIndexMap.get(rootValue); | 需要判断是否是 null，那么一定要是包装类型 Integer |
| 26   | -                                             | -                                                 | 需要手动 new TreeNode(rootValue)    |
| 27   | instart                                       | inStart                                           | 笔误                              |

```java
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 思路：前序+中序构造二叉树 => 前序确定根节点，中序分左右 => 之后在前序中递归的构造树
        // 		获取根节点在中序的位置，之后根据个数，可以拿到前序中左右子树的分界	
        // 		利用 map 可以在 O(1) 的时间内找到根节点在中序的位置
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueIndexMap.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valueIndexMap);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> valueIndexMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootValue = preorder[preStart];
        Integer rootIndex = valueIndexMap.get(rootValue);
        if (rootIndex == null) {
            return null;
        }
        TreeNode node = new TreeNode(rootValue);
        node.left = helper(preorder, preStart + 1, preStart + rootIndex - inStart, inorder, inStart, rootIndex - 1, valueIndexMap);
        node.right = helper(preorder, preStart + rootIndex - inStart + 1, preEnd, inorder, rootIndex + 1, inEnd, valueIndexMap);
        return node;
    }
}
```
