## 柱状图中最大的矩形

<https://leetcode-cn.com/problems/largest-rectangle-in-histogram/>

### 思路

1. Brute Force => 优化 => DUP 原则 => 有重复工作
2. 对于每个点，向两者扩展找到最大的面积
3. 对于每个点，其高度为自身的值h，求最大宽度 => 左右两侧找高度小于h的第一个值，两者相减即为最大宽度

#### 优化

DUP原则 => 当前有重复操作 => 一个单调栈解决 => 当 pop 的时候可以计算面积

1. [2, 1, 5, 6, 2, 3] => length = 6
2. [0, 1, 2, 3, 4, 5]
3. stack => 2
4. pop 2 => 2 * (1 - (-1) - 1) = 2 => popValue * (currentIndex - 栈顶元素Index - 1)
5. stack => 1
6. stack => 1, 5
7. stack => 1, 5, 6
8. pop 6 => 6 * (4 - 2 - 1) = 6 => popValue * (currentIndex - 栈顶元素Index - 1)
9. pop 5 => 5 * (4 - 1 - 1) = 10 => popValue * (currentIndex - 栈顶元素Index - 1)
10. stack => 1, 2
11. stack => 1, 2, 3
12. pop 3 => 3 * (6 - 4 - 1) = 3 => popValue * (length - 栈顶元素Index - 1)
13. pop 2 => 2 * (6 - 1 - 1) = 8 => popValue * (length - 栈顶元素Index - 1)
14. pop 1 => 1 * (6 - (-1) - 1) = 8 => popValue * (length - 栈顶元素Index - 1)
15. 如果 stack 为空，说明可以到最左侧，那么将是 -1

#### Brute Force

两层循环

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        // 时间复杂度：O(n^2)
        // 空间复杂度：O(1)
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int result = heights[0];
        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];
            int currentResult = heights[i];
            for (int j = i + 1; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                currentResult = Math.max(currentResult, minHeight * (j - i + 1));
            }
            result = Math.max(currentResult, result);
        }

        return result;
    }
}
```

注意点：

1. 结果初始值应为第一个元素值
2. 第一层循环可以到最后一个



