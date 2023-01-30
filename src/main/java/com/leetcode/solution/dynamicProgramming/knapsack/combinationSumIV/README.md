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
