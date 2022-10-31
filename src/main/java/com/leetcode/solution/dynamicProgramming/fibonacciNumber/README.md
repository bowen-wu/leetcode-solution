## 斐波那契数

<https://leetcode.cn/problems/fibonacci-number/>

### 思路

1. 递归

### 总结

| 问题行数 | 错误点        | 正确写法           | 错误原因 |
|------|------------|----------------|------|
| 35   | new int[n] | new int[n + 1] | 边界问题 |

```java
class Solution {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public int fibonacciTopToBottom(int n) {
        // 时间复杂度：O(n)
        if (n < 2) {
            return n;
        }
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;

        return fibonacciHelper(n, memo);
    }

    private int fibonacciHelper(int n, int[] memo) {
        if (memo[n] != -1) {
            return memo[n];
        }
        int result = fibonacciHelper(n - 1, memo) + fibonacciHelper(n - 2, memo);
        memo[n] = result;
        return result;
    }

    public int fibonacciBottomToTop(int n) {
        if (n < 2) {
            return n;
        }
        int[] memo = new int[n + 1];
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }

    public int fibonacciScrollArray(int n) {
        if (n < 2) {
            return n;
        }

        int associationNumber = 2;
        int[] memo = new int[associationNumber];
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i % associationNumber] = memo[(i - 1) % associationNumber] + memo[(i - 2) % associationNumber];
        }

        return memo[n % associationNumber];
    }
}
```
