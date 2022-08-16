## 旋转链表

<https://leetcode.cn/problems/rotate-list/>

### 思路

1. 求链表长度len
2. 移动距离 = k % len
3. 快指针先走移动距离
4. 快慢一起走，直到头
5. fast.next = head + head = slow.next + slow.next = null

#### 优化

1. 头节点改变 => Dummy Node
2. 注意连接顺序，要先连接，成环之后，再断开
