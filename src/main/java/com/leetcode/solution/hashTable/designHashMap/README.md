## 设计哈希映射

<https://leetcode.cn/problems/design-hashmap/>

### 思路

1. 开散列 => 数组 + 链表

### 总结

| 问题行数 | 错误点                                     | 正确写法                                    | 错误原因                                |
|------|-----------------------------------------|-----------------------------------------|-------------------------------------|
| 45   | table[hashcode] = new Node(key, value); | table[hashcode] = new Node(value, key); | 先 value 后 key。大失误                   |
| 38   | if (size * loadFactor > capacity)       | if (size > capacity * loadFactor)       | 想法错误。                               |
| 10   | -                                       | this.key = key                          | 初始化 Node 的时候没有写 this.key = key。重大失误 |
| 66   | node.next = new Node(key, value)        | node.next = new Node(value, key)        | key value 写反了。重大失误                  |
| 108  | for (int i = 0; i < size; i++)          | for (int i = 0; i < table.length; i++)  | 遍历 table。边界问题                       |

```java
class MyHashMap {
    // Ideas: 数组 + 链表实现哈希表
    static class Node {
        int val;
        int key;
        Node next;

        public Node(int val, int key, Node next) {
            this.val = val;
            this.key = key;
            this.next = next;
        }

        public Node(int val, int key) {
            this(val, key, null);
        }
    }

    public static int DEFAULT_CAPACITY = 16;
    public static float DEFAULT_LOAD_FACTOR = 0.75f;

    private Node[] table;
    private int capacity;
    private float loadFactor;
    private int size;

    public MyHashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table = new Node[capacity];
    }

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public void put(int key, int value) {
        if (size > capacity * loadFactor) {
            resize();
        }
        int hashcode = hash(key);
        Node node = table[hashcode];

        if (node == null) {
            table[hashcode] = new Node(value, key);
            size++;
            return;
        }

        // single node
        if (node.key == key) {
            // update
            node.val = value;
            return;
        }

        Node next = node.next;
        while (node != null) {
            if (node.key == key) {
                // update
                node.val = value;
                return;
            }
            if (next == null) {
                // node 是最后一个元素了
                node.next = new Node(value, key);
                size++;
                return;
            }

            node = node.next;
            next = next.next;
        }
    }

    public int get(int key) {
        int hashcode = hash(key);
        Node node = table[hashcode];
        while (node != null) {
            if (node.key == key) {
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hashcode = hash(key);
        Node node = table[hashcode];
        Node dummyNode = new Node(-1, -1, node);
        Node prev = dummyNode;
        while (node != null) {
            if (node.key == key) {
                prev.next = node.next;
                table[hashcode] = dummyNode.next;
                return;
            }
            node = node.next;
            prev = prev.next;
        }
    }

    private void resize() {
        int newCapacity = capacity * 2;
        this.capacity = newCapacity;
        Node[] newTable = new Node[newCapacity];
        for (int i = 0; i < table.length; i++) {
            Node node = table[i];
            while (node != null) {
                int newHashcode = hash(node.key);
                if (newTable[newHashcode] != null) {
                    Node newNode = newTable[newHashcode];
                    while (newNode.next != null) {
                        newNode = newNode.next;
                    }
                    newNode.next = new Node(node.val, node.key);
                } else {
                    newTable[newHashcode] = new Node(node.val, node.key);
                }
                node = node.next;
            }
        }

        this.table = newTable;
    }

    private int hash(int key) {
        return key % capacity;
    }
}
```
