## 接雨水

<https://leetcode.cn/problems/trapping-rain-water/>

### 思路

- case: [0,1,0,2,1,0,1,3,2,1,2,1] => 6
- 单调栈 => 单调递增 or 单调递减 => 使用**单调递减**
    1. 单调递增 => 上述前两个元素 => [0, 1] => 不能储水
    2. 单调递减 => [2, 1, 0] => 如果后面有墙则可以储水

1. push 0 => stack: [0]
2. pop 0 => 此时 stack is empty => 不计算
3. push 1 => stack: [1]
4. push 0 => stack: [1, 0]
5. pop 0 => 此时计算该处储水量 => area = (Math.min(2, 1) - 0) * (3 - 1 - 1) = 1
6. => area = (Math.min(currentValue, stack.peek()) - popValue) * (currentIndex - stack.peekIndex - 1)
7. pop 1 => 此时 stack is empty => 不计算
8. push 2 => stack: [2]
9. push 1 => stack: [2, 1]
10. push 0 => stack: [2, 1, 0]
11. pop 0 => 此时计算该处储水量 => area = (Math.min(1, 1) - 0) * (6 - 4 - 1) = 1
12. push 1 => stack: [2, 1, 1] => **遇到相等时不 pop**
13. pop 1 => 此时计算该处储水量 => area = (Math.min(3, 1) - 1) * (7 - 6 - 1) = 0
14. pop 1 => 此时计算该处储水量 => area = (Math.min(3, 2) - 1) * (7 - 3 - 1) = 3
15. pop 2 => 此时 stack is empty => 不计算
16. push 3 => stack: [3]
17. push 2 => stack: [3, 2]
18. push 1 => stack: [3, 2, 1]
19. pop 1 => 此时计算该处储水量 => area = (Math.min(2, 2) - 1) * (10 - 8 - 1) = 1
20. push 2 => stack: [3, 2, 2]
21. push 1 => stack: [3, 2, 2, 1]

### 总结

| 问题行数 | 错误点                | 正确写法 | 错误原因                          |
|------|--------------------|------|-------------------------------|
| 15   | NullPointException | -    | stack pop 之后有可能是空，在 peek 前要判空 |

```java
class Solution {
    public int trap(int[] height) {
        // 思路：栈底到栈顶单调递减栈。pop 的时候计算面积，右边界当前值，左边界 stack.peek()
        // => area = (Math.min(currentValue, stack.peekValue) - popValue) * (currentIndex - stack.peekIndex - 1)
        // 相等不 pop
        if (height == null || height.length == 0) {
            return 0;
        }

        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int popIndex = stack.pop();
                if (!stack.isEmpty()) {
                    result += (Math.min(height[i], height[stack.peek()]) - height[popIndex]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }

        return result;
    }
}
```
