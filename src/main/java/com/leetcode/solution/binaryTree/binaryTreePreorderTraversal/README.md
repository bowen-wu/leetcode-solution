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
