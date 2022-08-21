## 二叉树的中序遍历

<https://leetcode.cn/problems/binary-tree-inorder-traversal/>

### 思路

1. 递归遍历
2. 非递归遍历 => stack => 利用栈模拟递归 => O(n) + O(logn)
    1. 首先对左子树进行迭代
    2. 当前节点为空时进行出栈操作，并访问栈顶节点，将当前节点用右子节点代替
