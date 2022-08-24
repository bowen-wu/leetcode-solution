## 重排链表

<https://leetcode.cn/problems/reorder-list/>

### 思路

1. 使用栈
2. 翻转链表 => 翻转到中点即可
    1. 求中点 => 快慢指针
    2. 翻转 => 头插法 + Dummy Node
    3. 合并两个链表

#### 注意点

1. 关注从哪个点翻转链表。如果链表长度是偶数，求得的中点是前一个还是后一个
2. 翻转链表之后 middle.next 置为 null

### 总结

1. 合并两个链表注意**剩余，剩余，剩余**
2. 第三遍 => 合并两个链表注意**剩余，剩余，剩余**

```java
class Solution {
    public void reorderList(ListNode head) {
        // 思路：1. 找中点 2. 翻转 3. 合并两个链表 注意剩余
        if (head == null) {
            return;
        }
        ListNode middleNode = getMiddle(head);
        ListNode reverseNode = reverse(middleNode.next);
        middleNode.next = null;
        merge(head, reverseNode);
    }

    private ListNode getMiddle(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode node = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }
        return node;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        ListNode first = l1;
        ListNode second = l2;
        while (first != null && second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            current.next = first;
            current = current.next;
            current.next = second;
            current = current.next;
            first = firstNext;
            second = secondNext;
        }

        if (first != null) {
            current.next = first;
        }

        if (second != null) {
            current.next = second;
        }

        return dummyNode.next;
    }
}
```
