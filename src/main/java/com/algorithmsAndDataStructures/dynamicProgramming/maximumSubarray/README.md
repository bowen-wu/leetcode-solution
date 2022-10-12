## 最大子数组和

<https://leetcode.cn/problems/maximum-subarray/>

### 思路

1. 全局最优
2. State => dp[i] 代表以 nums[i] 结尾的子数组的最大和
3. Function => 制表法 => dp[i] = dp[i - 1] > 0 ? (dp[i - 1] + nums[i]) : nums[i]
4. Condition =>
    1. dp[0] = nums[0]

#### 优化

1. 滚动数组优化 => max + prevState 
