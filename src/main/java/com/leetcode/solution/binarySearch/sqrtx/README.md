## x 的平方根

<https://leetcode.cn/problems/sqrtx/>

### 思路

1. 取中点，
    - 中点 * 中点 > x => 在 (0, 中点)
    - 中点 * 中点 < x => 在 (中点, x)

#### 优化

1. 中点 * 中点 可能越界 => 中点 < x / 中点
2. start 初始值应该为 1

### 总结

| 问题行数    | 错误点           | 正确写法          | 错误原因                |
|---------|---------------|---------------|---------------------|
| 25 - 29 | -             | -             | 应该先判断 end，再判断 start |
| 18, 25  | mid * mid < x | mid < x / mid | 乘法可能越界              |

```java
class Solution {
    // 思路：二分查找。
    // n/2 * n/2 > n => [1, n/2]
    // n/2 * n/2 < n => [n/2, n]
    public int mySqrt(int x) {
        if (x < 0) {
            return -1;
        }

        if (x == 0) {
            return 0;
        }

        int start = 1;
        int end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid < x / mid) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end <= x / end) {
            return end;
        }

        return start;
    }
}
```
