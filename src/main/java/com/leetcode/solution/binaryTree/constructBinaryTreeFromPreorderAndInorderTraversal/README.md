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
