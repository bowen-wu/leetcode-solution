## 两两交换链表中的节点

<https://leetcode.cn/problems/swap-nodes-in-pairs/>

### 思路

1. 链表结构发生改变 => 头节点改变 => Dummy Node
2. 遍历
    1. 够不够两个
    2. 翻转
    3. 移动指针

### 总结

| 问题行数    | 错误点         | 正确写法                  | 错误原因                                      |
|---------|-------------|-----------------------|-------------------------------------------|
| 13 & 24 | return head | return dummyNode.next | 使用 Dummy Node 一定要返回 Dummy Node 的 next。不熟练 |

```java
class Solution {
    public ListNode swapPairs(ListNode head) {
        // 思路：检查够不够两个，够交换 1 次。头节点发生改变 => Dummy Node
        if (head == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        while (prev != null) {
            if (prev.next == null || prev.next.next == null) {
                return dummyNode.next;
            }

            ListNode current = prev.next;
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
            prev = current;
        }

        return dummyNode.next;
    }
}
```
