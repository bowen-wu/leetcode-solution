## 打家劫舍

<https://leetcode.cn/problems/house-robber/>

### 思路

1. State => f(n) 代表在 n 家时偷窃到的最高金额
    1. 偷第 n 家 => f(n - 2) + 第 n 家的金额
    2. 不偷第 n 家 => f(n - 1)
2. Function => f(n) = Math.max(f(n - 1), f(n - 2) + 第 n 家的金额)
3. Condition
4. Solution => 求解 f(n)

#### 注意

1. memo[0] = 0; & memo[1] = nums[0]
2. 可以移动到 nums.length
3. 第 i 家的金额 => nums[i - 1]
