## 最长递增子序列

<https://leetcode.cn/problems/longest-increasing-subsequence/>

### 思路

1. State => dp[i] 代表以 nums[i] 为结尾的最长递增子序列
2. 通过制表法推得结论 => dp[i] = Math.max(在之前小于 nums[i] 的子序列) + 1
3. 由于第 i 处的依赖需要遍历之前所有，所以无法状态压缩，不能用滚动数组
