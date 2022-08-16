## 反转链表

<https://leetcode.cn/problems/reverse-linked-list/>

### 思路

准备一个 node 节点，初始值为 null，遍历节点 node = new ListNode(currentNode.val, node)，O(n) + O(n)

#### 优化

1. O(1) 的空间复杂度 => 将当前节点的下一个节点保存，之后当前节点的 next = node，node = 当前节点，之后当前节点等于下一个节点
