## 重排链表

<https://leetcode.cn/problems/reorder-list/>

### 思路

1. 使用栈
2. 翻转链表 => 翻转到中点即可
    1. 求中点 => 快慢指针
    2. 翻转 => 头插法 + Dummy Node
    3. 合并两个链表

#### 注意点

1. 翻转链表从 middle.next
2. 翻转链表之后 middle.next 置为 null
