## 环形链表

<https://leetcode.cn/problems/linked-list-cycle/>

### 思路

快慢指针 => 如果快慢指针相遇，则成环

### 总结

| 问题行数    | 错误点 | 正确写法 | 错误原因                                       |
|---------|-----|------|--------------------------------------------|
| 13 - 15 | -   | -    | 要先移动之后判等，最初 fast == head，slow == head，二者相等 |

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 思路：快慢指针 => 相遇了则成环 O(n) + O(1)
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
```
