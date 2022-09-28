## LRU 缓存

<https://leetcode.cn/problems/lru-cache/>

### 思路

1. LRU(Least Recently Used) => 删除最久没有使用的 key value
2. LinkedHashMap => Map + 双向链表
    - 在 Map 的 Entry 上增加 before 和 after 指针，构造双向链表
    - 使用 head 和 tail 描述 eldest 和 youngest 节点
    - put => 将节点加入 Map 的链表中 + 连接双向链表(更新 tail，有可能删除 eldest 节点)
    - get => 在双向链表中移动当前节点到 tail 
    - remove => 在链表中删除 + 在双向链表中删除
3. 注意 LinkedHashMap 的 accessOrder
