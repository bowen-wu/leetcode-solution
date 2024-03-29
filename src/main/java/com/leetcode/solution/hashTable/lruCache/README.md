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

### 总结

| 问题行数    | 错误点               | 正确写法 | 错误原因                    |
|---------|-------------------|------|-------------------------|
| 40 - 56 | 先 remove 后 update | -    | put 时如果是更新则不能 remove。思路 |

```java
class LRUCache {
    // Ideas: map + doubleLinkedList
    static class DoubleLinkedList {
        DoubleLinkedList before;
        DoubleLinkedList after;
        int key;
        int value;

        public DoubleLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, DoubleLinkedList> map;
    DoubleLinkedList dummyHeadNode;
    DoubleLinkedList dummyTailNode;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dummyHeadNode = new DoubleLinkedList(-1, -1);
        this.dummyTailNode = new DoubleLinkedList(-1, -1);
        dummyHeadNode.after = dummyTailNode;
        dummyTailNode.before = dummyHeadNode;
    }

    public int get(int key) {
        // update position
        if (map.containsKey(key)) {
            DoubleLinkedList node = map.get(key);
            moveNodeToTail(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // update
            DoubleLinkedList node = map.get(key);
            node.value = value;
            moveNodeToTail(node);
            map.put(key, node);
            return;
        }

        // add
        if (map.size() >= capacity) {
            DoubleLinkedList removeNode = dummyHeadNode.after;
            DoubleLinkedList next = removeNode.after;
            dummyHeadNode.after = next;
            next.before = dummyHeadNode;
            map.remove(removeNode.key);
        }
        DoubleLinkedList node = new DoubleLinkedList(key, value);
        addNodeToTail(node);
        map.put(key, node);
    }

    private void moveNodeToTail(DoubleLinkedList node) {
        node.before.after = node.after;
        node.after.before = node.before;
        addNodeToTail(node);
    }

    private void addNodeToTail(DoubleLinkedList node) {
        node.before = dummyTailNode.before;
        node.after = dummyTailNode;
        dummyTailNode.before.after = node;
        dummyTailNode.before = node;
    }
}
```
