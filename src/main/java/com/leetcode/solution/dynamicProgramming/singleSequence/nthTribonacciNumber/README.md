## 第 N 个泰波那契数

<https://leetcode.cn/problems/n-th-tribonacci-number/>

### 思路

1. State => f(n) 表示第 n 个泰波那契数
2. Function => f(n) = f(n - 1) + f(n - 2) + f(n - 3)
3. Condition =>
    1. f(0) = 0;
    2. f(1) = 1
    3. f(2) = 1;
4. Solution => 求 f(n)

### 总结

| 问题行数 | 错误点      | 正确写法     | 错误原因 |
|------|----------|----------|------|
| 11   | return 0 | return 1 | 细节   |

```java
class Solution {
    public int tribonacci(int n) {
        // state => f(n) 表示第 N 个泰波那契数
        // status function => f(n) = f(n - 1) + f(n - 2) + f(n - 3)
        // condition => f(0) = 0 f(1) = 1 f(2) = 1
        // solution => 求 f(n)
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }

        int[] memo = new int[3];
        memo[1] = 1;
        memo[2] = 1;
        for (int i = 3; i <= n; i++) {
            memo[i % 3] = memo[(i - 1) % 3] + memo[(i - 2) % 3] + memo[(i - 3) % 3];
        }
        return memo[n % 3];
    }
}
```
