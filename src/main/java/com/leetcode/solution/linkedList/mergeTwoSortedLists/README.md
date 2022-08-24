## 合并两个有序链表

<https://leetcode.cn/problems/merge-two-sorted-lists/>

### 思路

两个指针比较，小的进入result

#### 优化

1. 剩余部分不需要遍历，只需要改变指针即可
2. 空间复杂度是 O(1)
