## 反转链表 II

<https://leetcode.cn/problems/reverse-linked-list-ii/>

### 思路

1. 使用 Dummy Node
2. 记录遍历次数 num
    - num < left => leftPrevNode
    - num >= left => 开始反转 reverseNode => 反转的头尾节点都需要
    - num > right => 停止反转 rightNextNode

#### 优化

1. 先移动 left 距离，只在再移动到 right 距离，此时需要反转

### 总结

| 问题行数 | 错误点                              | 正确写法                            | 错误原因                   |
|------|----------------------------------|---------------------------------|------------------------|
| 32   | retrurn                          | return                          | 笔误                     |
| 29   | if (len >= left && len <= right) | if (len >= left && len < right) | len 不能取到 right。边界问题。细心 |

```java
// while
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 思路：头节点可能改变 dummy node => 计数 O(n) + O(1)
        // 如果 num >= left && num <= right 反转
        if (head == null) {
            return null;
        }
        if (left < 1 || right < 1 || right < left) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode current = head;
        int len = 1;
        while (current != null) {
            if (len >= left && len < right) {
                // reverse
                ListNode temp = current.next;
                current.next = temp.next;
                temp.next = prev.next;
                prev.next = temp;
            } else {
                current = current.next;
                prev = prev.next;
            }
            len++;
        }

        return dummyNode.next;
    }
}
```

```java
// for
class Solution {
   public ListNode reverseBetween(ListNode head, int left, int right) {
      // 思路：头节点可能改变 dummy node => 计数 o(n) + o(1)
      //  dummyNode 开始，先走 left - 1 步，到达 prev，之后 i = left i < right 反转
      if (head == null) {
         return null;
      }
      if (left < 1 || right < 1 || right < left) {
         return head;
      }

      ListNode dummyNode = new ListNode(-1);
      dummyNode.next = head;
      ListNode prev = dummyNode;
      for (int i = 0; i < left - 1; i++) {
         if (prev == null) {
            return head;
         }
         prev = prev.next;
      }

      ListNode current = prev.next;
      for (int i = left; i < right; i++) {
         ListNode temp = current.next;
         current.next = temp.next;
         temp.next = prev.next;
         prev.next = temp;
      }

      return dummyNode.next;
   }
}
```
