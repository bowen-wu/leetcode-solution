## 最长递增子序列

<https://leetcode.cn/problems/longest-increasing-subsequence/>

### 思路

1. State => dp[i] 代表以 nums[i] 为结尾的最长递增子序列
2. 通过制表法推得结论 => dp[i] = Math.max(在之前小于 nums[i] 的子序列) + 1
3. 由于第 i 处的依赖需要遍历之前所有，所以无法状态压缩，不能用滚动数组

### 总结

| 问题行数 | 错误点                            | 正确写法                               | 错误原因 |
|------|--------------------------------|------------------------------------|------|
| 8    | reutrn 0;                      | return 0;                          | 大意   |
| 11   | int[] memo = int[nums.lenght]; | int[] memo = new int[nums.length]; | 大意   |

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        // state => f(n) 以 nums[n] 为终点的 LIS
        // status function => f(n) = Math.max(f(1),.... f(n - 1)) + 1
        // condition => x
        // solution => 求 LIS max 
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && memo[j] >= memo[i]) {
                    // update
                    memo[i] = memo[j] + 1;
                }
            }
        }

        int result = memo[0];
        for (int i = 1; i < memo.length; i++) {
            result = Math.max(result, memo[i]);
        }

        return result;
    }
}
```
