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
