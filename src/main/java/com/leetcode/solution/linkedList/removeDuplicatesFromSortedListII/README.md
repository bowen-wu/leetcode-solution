## 删除排序链表中的重复元素 II

<https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/>

### 思路

### 总结

| 问题行数 | 错误点                                                  | 正确写法                                            | 错误原因                                                 |
|------|------------------------------------------------------|-------------------------------------------------|------------------------------------------------------|
| 9    | -                                                    | -                                               | dummyNode 没有连接 head。大意                               |
| 15   | while (current.next != null && current.val == value) | while (current != null && current.val == value) | 边界问题。此处应该判断 current。大意                               |
| 18   | -                                                    | -                                               | 具体场景没有考虑完全，while 循环之后，此时的 current 便是不重复的第一个值，无需 next |

```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 思路：头节点会改变 Dummy Node，需要记录 prev。遍历链表，两根指针，遇到相等，找得到下一个不等的 O(n) + O(1)
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode current = head;
        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                int value = current.val;
                while (current != null && current.val == value) {
                    current = current.next;
                }
                prev.next = current;
            } else {
                prev = prev.next;
                current = current.next;
            }
        }

        return dummyNode.next;
    }
}
```
