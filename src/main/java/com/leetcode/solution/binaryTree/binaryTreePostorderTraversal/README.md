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
