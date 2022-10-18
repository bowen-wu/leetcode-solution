## 乘积最大子数组

<https://leetcode.cn/problems/maximum-product-subarray/>

### 思路

1. State => dp[i] 代表以 nums[i] 结尾的子数组最大乘积
2. case：2, -2, 2, -2 => 最大值应该 16
3. State => 需要有两个 dp
    1. maxDp[i] 代表以 nums[i] 结尾的子数组最大乘积
    2. minDp[i] 代表以 nums[i] 结尾的子数组最小乘积 => 考虑**负负得正**
4. Function
    1. nums[i] > 0 =>
        1. maxDp[i] = maxDp[i - 1] > 0 ? maxDp[i - 1] * nums[i] : nums[i]
        2. minDp[i] = minDp[i - 1] < 0 ? minDp[i - 1] * nums[i] : nums[i]
    2. nums[i] < 0 =>
        1. maxDp[i] = minDp[i - 1] < 0 ? minDp[i - 1] * nums[i] : nums[i]
        2. minDp[i] = maxDp[i - 1] > 0 ? maxDp[i - 1] * nums[i] : nums[i]
5. Condition =>
    1. maxDp[0] = nums[0];
    2. minDp[0] = nums[0];

#### 优化

1. 滚动数组 => minState + maxState + max
