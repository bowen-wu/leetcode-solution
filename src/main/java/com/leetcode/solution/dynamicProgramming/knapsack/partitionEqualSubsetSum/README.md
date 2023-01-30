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
