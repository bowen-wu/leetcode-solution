## 组合总和

<https://leetcode.cn/problems/combination-sum/>

### 思路

回溯法 => 组合问题

1. 是否需要对数据源排序 => 需要
2. 是否需要元素位置索引 => 组合问题，不需要
3. helper 函数定义 => ` void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int position, int target) `
4. 递归退出条件 => position >= nums.length
5. 单一解加入解集条件 => ` listSum == target `
6. 剪枝 => 如果当前 list 的和大于 target，不需要继续向下了
7. 如何递归分解子问题到下一层 => for loop
8. 如何回溯 => 删除单一解的最后一个元素

#### 优化

1. target 是变化的，target要去减当前值，那么就不用累加 list 了
