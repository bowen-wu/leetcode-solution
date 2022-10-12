## 最长递增子序列的个数

<https://leetcode.cn/problems/number-of-longest-increasing-subsequence/>

### 思路

1. 增加一个 count 数组 => count[i] 表示以 nums[i] 结尾的最长子序列个数
2. 在 nums[j] < nums[i] 的前提下
3. dp[i] < dp[j] + 1 => count[i] = count[j] => 第一次记录
4. dp[i] == dp[j] + 1 => count[i] + count[j] => 更新
