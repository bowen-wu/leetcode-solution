## 排序链表

<https://leetcode.cn/problems/sort-list/>

### 思路

1. 归并排序 => 递归拆分成两个链表，之后合并两个有序链表
    1. 求中点拆分链表
    2. 分成左右两个链表
    3. 合并两个有序链表
2. 快速排序
    1. dummyNode 不需要连接 head
    2. 低区可能是 null

### 总结

| 问题行数    | 错误点                                | 正确写法                                    | 错误原因                                         |
|---------|------------------------------------|-----------------------------------------|----------------------------------------------|
| 53      | ListNode right = sortList(middle); | ListNode right = sortList(middle.next); | 右侧的开始节点应该是中点的下一个节点。思路 + 细节                   |
| 27      | ListNode high = sortList(head);    | head.next = sortList(head.next);        | high 部分从 head.next 开始计算。思路 + 细节              |
| 32 - 35 | -                                  | -                                       | 获取 low 的最后一个元素，必须得到 low 之后才能拿到最后一个元素。思路 + 细节 |
| 19      | -                                  | prev.next = next;                       | 将前一个和后一个连接起来。细节                              |
| 31 - 34 | -                                  | -                                       | 获取 low 的最后一个元素，之后连接。细节                       |

```java
class Solution {
    public ListNode sortList(ListNode head) {
        // Ideas: Quick Sort => 通过划分调整大小关系
        // check input
        if (head == null || head.next == null) {
            return head;
        }

        int pivotValue = head.val;
        ListNode dummyNode = new ListNode(-1);
        ListNode prev = head;
        ListNode move = head.next;
        while (move != null) {
            if (move.val < pivotValue) {
                ListNode next = move.next;
                move.next = dummyNode.next;
                dummyNode.next = move;
                move = next;
                prev.next = next;
            } else {
                prev = prev.next;
                move = move.next;
            }
        }

        ListNode low = sortList(dummyNode.next);
        head.next = sortList(head.next);
        if (low == null) {
            return head;
        }
        ListNode last = low;
        while (last.next != null) {
            last = last.next;
        }
        last.next = head;
        return low;
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
        // Ideas: Merge Sort => Divider and Conquer
        //        1. get middle  2. sort  3. merge two sorted ListNode
        // check input
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = getMiddle(head);
        ListNode next = middle.next;
        middle.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(next);
        return mergeTwoSortedListNode(left, right);
    }

    private ListNode getMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode mergeTwoSortedListNode(ListNode left, ListNode right) {
        ListNode dummyNode = new ListNode(-1);
        ListNode node = dummyNode;
        while (left != null && right != null) {
            if (left.val > right.val) {
                node.next = right;
                right = right.next;
            } else {
                node.next = left;
                left = left.next;
            }
            node = node.next;
        }

        // remaining
        if (left != null) {
            node.next = left;
        }
        if (right != null) {
            node.next = right;
        }
        return dummyNode.next;
    }
}
```
