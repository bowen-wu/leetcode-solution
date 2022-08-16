## 链表的中间结点

<https://leetcode.cn/problems/middle-of-the-linked-list/>

### 思路

遍历，在遍历的过程中

- len 是奇数 => 不动
- len 是偶数 => 指向下一个

#### 优化

1. 同向型双指针 => 快慢指针
   - 链表长度奇数 => middle 只有一个
   - 链表长度偶数 => middle 有两个
