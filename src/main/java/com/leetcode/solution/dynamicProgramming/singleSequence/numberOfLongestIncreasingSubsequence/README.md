## 最长递增子序列的个数

<https://leetcode.cn/problems/number-of-longest-increasing-subsequence/>

### 思路

1. 增加一个 count 数组 => count[i] 表示以 nums[i] 结尾的最长子序列个数
2. 在 nums[j] < nums[i] 的前提下
3. dp[i] < dp[j] + 1 => count[i] = count[j] => 第一次记录
4. dp[i] == dp[j] + 1 => count[i] + count[j] => 更新

### 总结

1. 需要使用 results 记录每个位置的 LIS 个数

| 问题行数 | 错误点         | 正确写法                  | 错误原因                |
|------|-------------|-----------------------|---------------------|
| 35   | result = 1; | result = results[i];  | 应该等于 i 处的 result。思路 |
| 37   | result++    | result += results[i]; | 应该加 i 处的 result 。思路 |

```java
class Solution {
    public int findNumberOfLIS(int[] nums) {
        // state => f(n) 表示以 nums[n] 结尾的 LIS
        // status function => f(n) = Math.max(f(0), f(1)... f(n - 1)) + 1
        // condition => x
        // solution => 求 LIS max number
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] memo = new int[nums.length];
        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int currentLIS = 1;
            int currentResult = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (memo[j] + 1 > currentLIS) {
                        currentLIS = memo[j] + 1;
                        currentResult = results[j];
                    } else if (memo[j] + 1 == currentLIS) {
                        currentResult += results[j];
                    }
                }
            }
            memo[i] = currentLIS;
            results[i] = currentResult;
        }

        int max = memo[0];
        int result = 0;
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] > max) {
                max = memo[i];
                result = results[i];
            } else if (memo[i] == max) {
                result += results[i];
            }
        }
        return result;
    }
}
```
