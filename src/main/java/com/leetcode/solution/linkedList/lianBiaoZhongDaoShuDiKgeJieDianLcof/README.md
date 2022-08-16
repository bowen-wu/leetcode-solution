## 链表中倒数第k个节点

<https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/>

### 思路

双指针 => 记录快慢指针的间隔，如果间隔 <= k，慢指针不动，间隔 > k，双指针一起移动

#### 优化

1. 可以让快指针先走 K 步，之后快慢再同步走 => 好理解
