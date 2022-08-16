## 删除链表的倒数第 N 个结点

<https://leetcode.cn/problems/remove-nth-node-from-end-of-list/>

### 思路

找到前一个，之后移动指针

### 总结

1. 指针移动时要判断是否移动到了 null，**移动到 null 代表多走了一步**
2. 删除时关注是否是 null
