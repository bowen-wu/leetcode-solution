## K 个一组翻转链表

<https://leetcode.cn/problems/reverse-nodes-in-k-group/>

### 思路

1. 链表结构变化 => 头节点可能改变 => Dummy Node
2. 遍历
    1. 判断够不够 k 个
    2. 翻转 k-1 次
    3. 移动指针 
