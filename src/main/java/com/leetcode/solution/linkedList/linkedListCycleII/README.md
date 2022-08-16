## 环形链表 II

<https://leetcode.cn/problems/linked-list-cycle-ii/>

### 思路

双指针 => 判断是否成环 => 成环了之后查找入环点

设 head 到入环点距离为a，入环点到快慢指针相遇的地方为b，快慢指针相遇的地方到入环点为c

- S<sub>fast</sub> = 2 * S<sub>slow</sub> => 路程关系
- S<sub>fast</sub> = a + n(b + c) + b
- S<sub>slow</sub> = a + b
- a + n(b + c) + b = 2(a + b) => **a = (n - 1)(b + c) + c**
- b + c 是一个环
- 此时 currentPoint 从 head 走到入环点，即a
- 此时慢指针从相遇点走到入环点，即c
- currentPoint 和慢指针相遇的地方就是入环点

