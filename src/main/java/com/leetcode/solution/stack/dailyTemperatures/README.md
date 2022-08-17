## 每日温度

<https://leetcode.cn/problems/daily-temperatures/>

### 思路

使用单调栈

- **右侧** => 从左向右遍历
- **Greater** => 栈底到栈顶单调递减

#### 优化

1. 进行参数判断

### 总结

| 问题行数 | 错误点                                          | 正确写法                       | 错误原因        |
|------|----------------------------------------------|----------------------------|-------------|
| 13   | temperatures[stack.peek()] temperatures[i]   | -                          | 判断条件忘记写了，大意 |
| 15   | temperatures[index] = i - index;             | result[index] = i - index; | 笔误          |
| 15   | temperatures[stack.pop()] = temperatures[i]; | -                          | 审题          |

```java
class Solution {
    // 思路：
    // 1. Brute Force：双层 for loop，时间复杂度O(n^2)
    // 2. 单调栈 => 栈底到栈顶单调递减栈，当入栈比栈顶元素大时，破坏单调性，此时记录两者 index 差值即可。O(n) + O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return null;
        }

        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }
}
```
