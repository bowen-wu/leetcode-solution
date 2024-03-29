## 旋转链表

<https://leetcode.cn/problems/rotate-list/>

### 思路

1. 求链表长度len
2. 移动距离 = k % len
3. 快指针先走移动距离
4. 快慢一起走，直到头
5. fast.next = head + head = slow.next + slow.next = null

#### 优化

1. 头节点改变 => Dummy Node
2. 注意连接顺序，要先连接，成环之后，再断开

### 总结

| 问题行数 | 错误点         | 正确写法 | 错误原因                |
|------|-------------|------|---------------------|
| 32   | return fast | -    | 应该返回 slow 的下一个元素。大意 |

```java
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // 思路：get length => k % length => 倒数第 k % length + 1 的点 => 连接
        if (head == null) {
            return null;
        }
        if (k < 1) {
            return head;
        }

        int length = 0;
        ListNode lenNode = head;
        while (lenNode != null) {
            lenNode = lenNode.next;
            length++;
        }

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k % length; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;
        ListNode temp = slow.next;
        slow.next = null;
        return temp;
    }
}
```
