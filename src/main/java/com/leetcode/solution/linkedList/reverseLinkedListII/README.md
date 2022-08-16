## 反转链表 II

<https://leetcode.cn/problems/reverse-linked-list-ii/>

### 思路

1. 使用 Dummy Node
2. 记录遍历次数 num
    - num < left => leftPrevNode
    - num >= left => 开始反转 reverseNode => 反转的头尾节点都需要
    - num > right => 停止反转 rightNextNode

#### 优化

1. 先移动 left 距离，只在再移动到 right 距离，此时需要反转
