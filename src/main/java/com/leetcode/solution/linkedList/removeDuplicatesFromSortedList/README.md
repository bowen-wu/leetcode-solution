## 删除排序链表中的重复元素

<https://leetcode.cn/problems/remove-duplicates-from-sorted-list/>

### 思路

如果当前元素和下一个元素值相等，当前元素的 next 指针变更为下一个元素的 next 指针

### 总结

| 问题行数 | 错误点                | 正确写法 | 错误原因       |
|------|--------------------|------|------------|
| 17   | 没有写 current = next | -    | 死循环。没有移动指针 |

```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 思路：遍历，如果 current.val == next.val，找到下一个不等的，current.next = unequal
        if (head == null) {
            return null;
        }
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            if (next != null && current.val == next.val) {
                int value = current.val;
                while (next != null && next.val == value) {
                    next = next.next;
                }
            }
            current.next = next;
            current = next;
        }
        return head;
    }
}
```
