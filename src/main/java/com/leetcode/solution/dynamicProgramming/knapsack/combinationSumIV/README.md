## 组合总和 Ⅳ

<https://leetcode.cn/problems/combination-sum-iv/>

### 思路

1. nums[i]只能取一次 => 01背包
2. nums[i]能够无限次取 => 完全背包
3. 顺序不同的序列是**相同**的组合 => 先遍历硬币
4. 顺序不同的序列是**不同**的组合 => 先遍历金额
5. state => dp[i]表示总和为i的元素组合个数
6. statue function => dp[i] = sum(dp[i - nums[j]])
7. condition => dp[0] = 1
8. solution => dp[target]
9. 当前nums[i]无负数，如果有负数可以增加**组合的长度限制**

### 总结

| 问题行数    | 错误点             | 正确写法 | 错误原因 |
|---------|-----------------|------|------|
| 12 - 13 | 没有进行判断 i >= num | -    | 大意   |

```java
class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < 0) {
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }
}
```
