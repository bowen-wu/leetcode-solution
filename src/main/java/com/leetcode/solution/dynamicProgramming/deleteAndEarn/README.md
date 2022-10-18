## 删除并获得点

<https://leetcode.cn/problems/delete-and-earn/>

### 思路

1. 取一个数 num，那么数组中所有等于这个值的数字都会被取到
2. 所有等于 num - 1 和 num + 1 的数字都会被删除
3. 选择 num 前后都不能选择 => 价值数组
4. 价值数组 values => num 为下标，**num * 出现次数**为值的数组
5. 打家劫舍问题
    1. State => memo[i] 代表到第 i 家偷窃的金额
    2. Function => memo[i] = max(偷窃当前家，不偷窃当前家) => Math.max(memo[i - 1], memo[i - 2] + values[i])
    3. Condition =>
        1. memo[0] = value[0];
        2. memo[1] = value[1];
