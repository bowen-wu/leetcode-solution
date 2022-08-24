## K 个一组翻转链表

<https://leetcode.cn/problems/reverse-nodes-in-k-group/>

### 思路

1. 链表结构变化 => 头节点可能改变 => Dummy Node
2. 遍历
    1. 判断够不够 k 个 => for 循环判断
    2. 翻转 k-1 次
    3. 移动指针

### 总结

1. 思路 => 使用 while + for 循环
    1. 使用 for 循环判断够不够 k 个
    2. 使用 for 循环 reverse k - 1 次
    3. 移动指针

| 问题行数 | 错误点                    | 正确写法                   | 错误原因 |
|------|------------------------|------------------------|------|
| 15   | LitNode                | ListNode               | 大意   |
| 22   | return dummuNode.next; | return dummyNode.next; | 大意   |

```java
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 思路：头节点改变 DummyNode while + for loop
        // 	1. 使用 for 循环判断够不够 k 个 2. 使用 for 循环 reverse k - 1 次 3. 移动指针 
        if (head == null) {
            return null;
        }

        if (k < 1) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode current = head;

        while (current != null) {
            ListNode check = current;
            for (int i = 0; i < k; i++) {
                if (check == null) {
                    return dummyNode.next;
                }
                check = check.next;
            }

            // reverse
            for (int i = 0; i < k - 1; i++) {
                ListNode temp = current.next;
                current.next = temp.next;
                temp.next = prev.next;
                prev.next = temp;
            }

            prev = current;
            current = current.next;
        }

        return dummyNode.next;
    }
}
```
