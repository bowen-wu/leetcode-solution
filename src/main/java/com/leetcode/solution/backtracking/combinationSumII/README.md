## 组合总和 II

<https://leetcode.cn/problems/combination-sum-ii/>

### 思路

回溯法 => 找子集 => 组合问题

1. 是否需要排序 => 需要
2. 是否需要元素位置索引 => 需要
3. helper 函数定义 => ` void helper(List<List<Integer> result, List<Integer> list, int[] nums, int position, int target) `
4. 递归退出条件 => position >= nums.length
5. 单一解何时加入解集 => target == 0
6. 剪枝 => target < 0 + nums[i] > target
7. 如何分解子问题到下一层 => for loop
8. 如何回溯 => 单一解移除最后一个元素
9. 优化 => target 逐步递减，便可以不用计算 list 的 sum
10. 解集不能包含重复的组合 => 当前元素和前一个元素相等则跳过
