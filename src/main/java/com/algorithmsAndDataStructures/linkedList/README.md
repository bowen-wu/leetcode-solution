# 链表

## 概述

链表(linked list)是一种线性表，但是并不会按线性的顺序存储数据，而是在每一个节点里存储到下一个节点的指针

## 特性

### 单链表

- 每个节点都知道它下一个节点的地址
- 元素不存储在连续内存位置
- 链表的第一个节点可以代表整个链表
- 查找一个节点或者访问特定编号的节点则需要O(n)的时间

## 定义

### 单链表

```java
// 链表节点
public class ListNode {
    private int val;
    private ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
```

```javascript
function listNode(val) {
  this.val = val;
  this.next = null;
}
```

## 使用场景

1. 不确定数据结构的容量时
    - 数组大小调整的成本非常大，所以我们需要提前设置容量
    - 通常我们不知道我们需要多少空间花费
2. 常用于**遍历、检索操作较少，添加、删除操作较多**的数据

## 链表应用实例

1. LRU cache => 最近最少使用缓存策略
2. Java 中 AQS 框架 => CLH 队列
3. Java HashMap/ConcurrentHashMap => 数组 + 链表 + 红黑树
4. Redis 中的 List
5. C语言中的 malloc 函数实现
6. 文件系统(FAT)

## 实现链表与基本操作

- 属性
- 构造器
- 方法
    - 查找/获取
    - 添加
    - 更改
    - 删除
    - 获取长度

```java
public class LinkedList {
    // Field
    private ListNode head;
    private ListNode tail;
    private int length;

    // Constructor
    public LinkedList() {
    }

    public LinkedList(ListNode head) {
        this.head = head;
        this.tail = head;
        this.length = 1;
    }

    // Method
    public int getValue(int index) {
        ListNode node = getNode(index);

        if (node == null) {
            throw new RuntimeException("The node for index is empty!");
        }

        return node.val;
    }

    public ListNode getNode(int index) {
        checkIndexRange(index);
        int currentIndex = 0;
        ListNode result = head;
        while (currentIndex < index) {
            result = result.next;
            currentIndex++;
        }
        return result;
    }

    public void add(int index, int value) {
        checkIndexRangeForAdd(index);

        if (index == length) {
            append(value);
            return;
        }
        ListNode newNode = new ListNode(value);
        if (index == 0) {
            newNode.next = head;
            this.head = newNode;
        } else {
            ListNode prevNode = getNode(index - 1);
            ListNode nextNode = prevNode.next;
            prevNode.next = newNode;
            newNode.next = nextNode;
        }
        length++;
    }

    public void addWithDummyNode(int index, int value) {
        checkIndexRangeForAdd(index);

        if (index == length) {
            append(value);
            return;
        }

        ListNode newNode = new ListNode(value);

        // Build dummy node
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = this.head;
        ListNode prevNode = dummyNode;

        while (index-- != 0) {
            prevNode = prevNode.next;
        }

        ListNode nextNode = prevNode.next;
        prevNode.next = newNode;
        newNode.next = nextNode;
        this.head = dummyNode.next;
        length++;
    }


    public void append(int value) {
        ListNode node = new ListNode(value);
        if (this.tail == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
        length++;
    }

    public void set(int index, int value) {
        ListNode node = getNode(index);
        node.val = value;
    }

    public int removeByIndex(int index) {
        checkIndexRange(index);
        length--;
        ListNode removeNode;
        if (index == 0) {
            removeNode = head;
            this.head = head.next;
        } else {
            ListNode prevNode = getNode(index - 1);
            if (index == length - 1) {
                removeNode = tail;
                prevNode.next = null;
                this.tail = prevNode;
            } else {
                removeNode = prevNode.next;
                prevNode.next = removeNode.next;
            }
        }
        removeNode.next = null;
        return removeNode.val;
    }

    public int removeByIndexWithDummyNode(int index) {
        checkIndexRange(index);
        length--;

        // Build dummy node
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prevNode = dummyNode;

        while (index > 0) {
            prevNode = prevNode.next;
            index--;
        }

        ListNode removeNode = prevNode.next;
        prevNode.next = removeNode.next;

        if (index == length - 1) {
            prevNode.next = null;
            this.tail = prevNode;
        }

        removeNode.next = null;
        this.head = dummyNode.next;
        return removeNode.val;
    }

    public void removeByValue(int value) {
        ListNode prevNode = head;
        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            if (prevNode == currentNode && currentNode.val == value) {
                // 删除头节点
                prevNode = nextNode;
                this.head.next = null;
                this.head = nextNode;
            } else {
                if (currentNode.val == value) {
                    prevNode.next = nextNode;
                    currentNode.next = null;
                } else {
                    prevNode = currentNode;
                }
            }
            currentNode = nextNode;
        }
    }

    public int getLength() {
        return length;
    }

    public int getLengthByTraverse() {
        int len = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            len++;
            currentNode = currentNode.next;
        }

        return len;
    }


    private void checkIndexRange(int index) {
        if (index < 0 || index >= length) {
            throw new RuntimeException("The index is invalid!");
        }
    }

    private void checkIndexRangeForAdd(int index) {
        if (index < 0 || index > length) {
            throw new RuntimeException("The index is invalid!");
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(0, 2);
        linkedList.add(1, 3);
        linkedList.add(2, 1);
        linkedList.add(3, 6);
        linkedList.add(4, 5);
        linkedList.add(5, 2);

        linkedList.removeByValue(2);
        System.out.println(linkedList);
    }
}

// 链表节点
class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
```

### Dummy Node 哨兵

1. 简化边界情况 => 使得链表原头节点不再特殊
2. 链表总是存在至少一个节点，但链表的真正元素是从哨兵节点的下一个节点开始

```
// Build dummy node
ListNode dummyNode = new ListNode(-1);
dummyNode.next = head;
ListNode prevNode = dummyNode;
```

- 如果链表的数据结构发生变化，则需要考虑使用 Dummy Node => 如：add/remove 操作
- 链表节点只能通过前一个节点的指针访问，在将当前节点分配给新节点之前，不要更改上一个节点的 next 指针，这样会丢失当前节点

## 总结

### 两类问题

1. 与计数或位置相关的问题
2. 与链表结构变化相关的问题

### 方法

1. Dummy Node
2. 链表基本操作 => 插入、删除、翻转
3. 同向型双指针 => 快慢指针

### 获取index处的节点

```
ListNode currentNode = head;
while (index-- > 0) {
    currentNode = currentNode.next;
}
return currentNode;

ListNode currentNode = head;
for (int i = 0; i < index - 1; i++) {
    currentNode = currentNode.next
}
return currentNode;
```

## 同向型双指针(快慢指针)

```
public boolean fastSlowPoint(ListNode head) {
    if (head == null) {
        return false;
    }

    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        // do something 
    }
}
```

## 链表问题关键步骤

1. 快慢双指针
2. 链表结构会不会变化 => 头节点会不会变化 => Dummy Node
3. 翻转链表用头插法
4. 画图关注节点连接和断开 => 画出最后的 null 节点

## 翻转链表

1. 全部翻转 => prev = null
   ```
    ListNode prev = null;
    ListNode currentNode = head;
    while (head != null) {
        ListNode temp = currentNode.next;
        currentNode.next = prev;
        prev = head;
        head = temp;
    }

    return prev;
   ```
2. 部分翻转 => prev = ListNode
   ```
   ListNode prev = xxx;
   ListNode currentNode = prev.next;
   while (currentNode != null) {
        ListNode temp = currentNode.next;
        currentNode.next = temp.next;
        temp.next = prev.next;
        prev.next = temp;
   }
   ```

## 判断链表够不够 K 个

```java
public class Demo {
    public boolean enoughK(int k, ListNode head) {
        for (int i = 0; i < k; i++) {
            if (head == null) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
```

## 中点问题

- 链表长度奇数 => middle 只有一个
- 链表长度偶数 => middle 有两个
    1. 求前一个 => fast 先走一步
    2. 求后一个 => fast slow 一起走
