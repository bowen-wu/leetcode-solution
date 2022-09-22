# 哈希表

## 概述

- 数据结构
    1. 连续型 => 数组(栈)
    2. 离散型 => 链表(队列 => 双端链表) | 二叉树
- 拥有键值对元素的无序集合
- 键的值是唯一的，键对应的值可以通过键来获取、更新或移除
- Insert/Search/Delete => O(1)

## 基本原理

- 数组通过下标访问数据的一种拓展
- 核心：利用哈希函数，将键值映射到数组上 => bucket

## 重要概念

- 键值对
- 哈希桶/哈希槽
- 装填因子/负载因子 => Load Factor
- 哈希函数/散列函数
- 哈希冲突

### Hash Function 哈希函数

- 哈希函数是用来将一个字符串(或任何其他类型)转化为小于哈希表大小且大于等于0的整数
- 一个好的哈希函数
    1. 可以尽可能少地产生冲突
    2. 算的快

#### Times 33 算法

- 假设任何字符串都是基于33的一个大整数
-

case: ` hashcode("abcd") = (ascii(a) * (33 ^ 3) + ascii(b) * (33 ^ 2) + ascii(c) * (33 ^ 1) + ascii(d) * (33 ^ 0)) % hashSize `

- 给出一个字符串作为 key 和一个哈希表的大小，返回这个字符串的哈希值
  ```
  public int hashCode(char[] key, int hashSize) {
    lont result = 0;
    for (int i = 0; i < key.length; i++) {
      result = (result * 33 + ((int) key[i])) % hashSize;
    }
    return (int) result;
  }
  ```

### 哈希冲突

- 无论使用什么 Hash Function，都需要考虑冲突问题
- 为啥会有冲突
    1. 有一些 key 会 map 到相同的 index 上
    2. **无限空间往有限空间映射**

#### 解决哈希冲突

1. 设计好的 Hash Function
2. 改变 Hash 索引
    1. Open Hashing
    2. Closed Hashing
3. 扩容 => 负载因子 Load Factor: size/capacity => Java: LF > 0.75 -> resize()

##### 闭散列 Closed Hashing

闭散列 => 开放定址法 => **负载因子大的时候还是会有冲突**

1. 线性探测 => hash = (hash(key) + i) % HASH_SIZE => i = 0, 1, 2, 3...
2. 二次探测 => hash = (hash(key) + i ^ 2) % HASH_SIZE => i = 0, 1, 2, 3...
3. 双重散列 => 使用两个 Hash Function，如果第一个 Hash Function 冲突了，就使用第二个 Hash Function

##### 开散列 Open Hashing

开散列 => 拉链法 => 每个 bucket 对应一条链表，哈希值相同的元素直接连接在对应**链表**中 => 数组 + 链表

##### 扩容

- 重哈希 => rehashing
- 哈希表容量的大小在一开始是不确定的
- 如果哈希表存储元素太多，将哈希表容量扩大一倍，并将所有的 key 的哈希值重新计算映射到新的 bucket 上
- 渐进式 rehash => 避免集中 rehash 带来的庞大的计算量和内存操作

```java
class Rehashing {
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null || hashTable.length == 0) {
            return null;
        }
        int capacity = hashTable.length;
        int newCapacity = capacity * 2;
        ListNode[] newHashTable = new ListNode[newCapacity];

        for (ListNode head : hashTable) {
            while (head != null) {
                int key = head.val;
                int hashcode = key % newCapacity;
                if (newHashTable[hashcode] != null) {
                    ListNode node = newHashTable[hashcode];
                    while (node != null && node.next != null) {
                        node = node.next;
                    }
                    node.next = new ListNode(key);
                } else {
                    newHashTable[hashcode] = new ListNode(key);
                }
                head = head.next;
            }
        }
        return newHashTable;
    }
}
```

## 基本操作

以 Java 为例

- 增 => put
- 删 => remove/clear
- 改 => put
- 查 => get
- containsKey/containsValue
- size/isEmpty
- 遍历 => keySet/values/entrySet/forEach

```java
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Traversal {
    public Map<String, String> map = new HashMap<>();

    public void traversalForLambda() {
        // 推荐
        map.forEach((key, value) -> System.out.println("The key: " + key + ", the value: " + value));
    }

    public void traversalForEach() {
        // 推荐
        for (Entry<String, String> entry : map.entrySet()) {
            System.out.println("The key: " + entry.getKey() + ", the value: " + entry.getValue());
        }
    }

    public void traversalForKeySet() {
        for (String key : map.keySet()) {
            System.out.println("The key: " + key + ", the value: " + map.get(key));
        }
    }

    public void traversalForIterator() {
        Iterator<Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Entry<String, String> entry = iterator.next();
            System.out.println("The key: " + entry.getKey() + ", the value: " + entry.getValue());
        }
    }
}
```

## 知识点

- Java1.7 扩容时 => 头插法 => 有死循环
- Java1.8 扩容时 => 尾插法 => 避免死循环
