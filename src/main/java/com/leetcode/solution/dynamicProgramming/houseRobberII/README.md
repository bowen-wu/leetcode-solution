## 打家劫舍 II

<https://leetcode.cn/problems/house-robber-ii/>

### 思路

1. 房屋成环 => 偷窃第一家就不能偷窃最后一家，偷窃第二家，可能会偷窃最后一家
2. 分成两个 打家劫舍 问题
    1. State => memo[i] 代表到达第 i 家偷窃的金额
    2. 偷窃第一家 => Function => memo[i] = Math.max(memo[i - 1], memo[i - 2] + nums[i - 1]) => 如果是最后一家则不偷窃
    3. 偷窃第二家 => Function => memo[i] = Math.max(memo[i - 1], memo[i - 2] + nums[i - 1])
