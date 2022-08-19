## 回文链表

<https://leetcode.cn/problems/palindrome-linked-list/>

### 思路

1. 找中点
2. 翻转
3. 比较

### 总结

| 问题行数 | 错误点         | 正确写法        | 错误原因 |
|------|-------------|-------------|------|
| 5    | return null | return true | 大意   |
| 8    | reveseNode  | reverseNode | 大意   |

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        // 思路：找第一个中点，翻转，比较
        if (head == null) {
            return true;
        }
        ListNode middleNode = getMiddle(head);
        ListNode reverseNode = reverse(middleNode.next);
        while (head != null && reverseNode != null) {
            if (head.val != reverseNode.val) {
                return false;
            }
            head = head.next;
            reverseNode = reverseNode.next;
        }
        return true;
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
}
```
