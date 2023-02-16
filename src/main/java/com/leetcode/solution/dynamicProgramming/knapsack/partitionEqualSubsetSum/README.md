## 分割等和子集

<https://leetcode.cn/problems/partition-equal-subset-sum/>

### 思路

1. 01背包
2. 偶数才能平分
3. 对于`nums[i]`只能选一次
4. state => dp[i][j] 表示从前i个数字中选择，选择到的数字之和为j的情况是否存在
5. status function => dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j] => 选`nums[i]`和不选`nums[i]`
6. condition => dp[0][0] = true dp[i][0] = true dp[0][j] = false
7. solution => dp[len][sum/2]

### 总结

1. 空间优化到一个数组的时候需要从后往前计算

| 问题行数    | 错误点                     | 正确写法                    | 错误原因 |
|---------|-------------------------|-------------------------|------|
| 29 - 33 | dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]]; | 需要判断 j - nums[i] |

```java
class Solution {
    public boolean canPartition(int[] nums) {
        // 01背包
        // state => dp[i][j] 表示前i个数字和为j的可能性
        // status function => dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]]
        // condition => dp[i][0] = true  dp[0][j] = false;
        // solution => dp[len][sum / 2]
        if (nums == null || nums.length < 2) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }
        int len = nums.length;
        int max = sum / 2;
        boolean[][] dp = new boolean[2][max + 1];
        dp[0][0] = true;

        for (int i = 1; i < len; i++) {
            dp[i % 2][0] = true;

            for (int j = 1; j <= max; j++) {
                if (j >= nums[i]) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j] || dp[(i - 1) % 2][j - nums[i]];
                } else {
                    dp[i % 2][j] = dp[(i - 1) % 2][j];
                }
            }
        }

        return dp[(len - 1) % 2][sum / 2];
    }
}
```

