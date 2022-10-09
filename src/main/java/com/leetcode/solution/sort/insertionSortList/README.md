## 对链表进行插入排序

<https://leetcode.cn/problems/insertion-sort-list/>

### 思路

1. DummyNode
2. 插入排序，逐步比较 => 找到第一个比它大的，插在前面即可，如果没有，则放在后面

### 总结

| 问题行数 | 错误点 | 正确写法             | 错误原因                       |
|------|-----|------------------|----------------------------|
| 22   | -   | node = dummyNode | node 没有 reset dummyNode。思路 |

```java
class Solution {
    public ListNode insertionSortList(ListNode head) {
        // check input
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode node = dummyNode;
        while (head != null) {
            while (node.next != null) {
                if (node.next.val > head.val) {
                    break;
                }
                node = node.next;
            }
            ListNode headNext = head.next;
            ListNode next = node.next;
            node.next = head;
            head.next = next;
            head = headNext;
            node = dummyNode;
        }

        return dummyNode.next;
    }
}
```