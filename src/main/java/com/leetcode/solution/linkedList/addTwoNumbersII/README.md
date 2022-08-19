## 两数相加 II

<https://leetcode.cn/problems/add-two-numbers-ii/>

### 思路

1. 翻转链表
2. 相加
3. 翻转链表

#### 优化

1. 使用栈 => 额外空间

### 总结

| 问题行数    | 错误点                  | 正确写法 | 错误原因   |
|---------|----------------------|------|--------|
| 25 & 28 | 未判断是否是 null， 就 .next | -    | **细节** |

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 思路：翻转 + 相加 + 翻转 O(n) + O(1)
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode l1Reverse = reverse(l1);
        ListNode l2Reverse = reverse(l2);

        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        int carry = 0;
        while (l1Reverse != null || l2Reverse != null) {
            int num1 = l1Reverse == null ? 0 : l1Reverse.val;
            int num2 = l2Reverse == null ? 0 : l2Reverse.val;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (l1Reverse != null) {
                l1Reverse = l1Reverse.next;
            }
            if (l2Reverse != null) {
                l2Reverse = l2Reverse.next;
            }
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return reverse(dummyNode.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode node = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = node;
            node = head;
            head = next;
        }
        return node;
    }
}
```

1. 注意头插

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 思路：使用栈 => O(n) + O(m + n) + 头插
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummyNode = new ListNode(-1);
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            dummyNode.next = new ListNode(sum % 10, dummyNode.next);
        }

        if (carry > 0) {
            dummyNode.next = new ListNode(carry, dummyNode.next);
        }

        return dummyNode.next;
    }
}
```
