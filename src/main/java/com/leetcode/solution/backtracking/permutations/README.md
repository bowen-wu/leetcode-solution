## 全排列

<https://leetcode.cn/problems/permutations/>

### 思路

回溯法

1. 是否需要对数据源排序 => 不需要，无重复元素
2. 是否需要元素位置索引 => 排列，不需要
3. helper 函数定义 => ` void helper(List<List<Integer>> result, List<Integer> list, int[] nums) `
4. 递归退出条件 => ` list.size() == nums.length `
5. 单一解加入解集条件 => ` list.size() == nums.length `
6. 如何剪枝 => 不需要剪枝
7. 如何递归分解子问题到下一层 => for loop
8. 如何回溯 => 删除单一解的最后一个元素
