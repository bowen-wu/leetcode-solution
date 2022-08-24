## 两数相加

<https://leetcode.cn/problems/add-two-numbers/>

### 思路

双指针

#### 优化

1. 剩余的值中，可能还有进位，不能直接改变指针，还有看进位
2. 全部遍历结束，还要看是否有进位

### 总结

| 问题行数           | 错误点                 | 正确写法    | 错误原因             |
|----------------|---------------------|---------|------------------|
| 18             | nums2               | num2    | 大意               |
| 19             | int carry =         | carry = | 外部已经定义了 carry。大意 |
| 21 & 24        | 未判断是否是 null，就 .next | -       | **细节**           |
| 第三遍 => 21 & 24 | 未判断是否是 null，就 .next | -       | **细节**           |

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 思路：两根指针一起走，记录 carry + Dummy Node O(n) + O(1)
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode first = l1;
        ListNode second = l2;
        int carry = 0;
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        while (first != null || second != null) {
            int num1 = first != null ? first.val : 0;
            int num2 = second != null ? second.val : 0;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyNode.next;
    }
}
```
