## 全排列 II

<https://leetcode.cn/problems/permutations-ii/>

### 思路

回溯法 => 找到所有方案

1. 是否需要对数据源排序 => 需要
2. 是否需要元素位置索引 => 不需要
3. helper 函数定义 => ` void helper(List<List<Integer>> result, List<Integer> list, int[] nums) `
4. 递归退出条件 => ` list.size() == nums.length `
5. 单一解加入解集条件 => ` list.size() == nums.length `
6. 如何剪枝 =>
    1. 构造节点访问数组 => 访问过为 true，没访问过是 false
    2. 剪枝1 => for loop 时如果该元素访问过则跳过
    3. 剪枝2 => 如果该元素和前一个元素相同并且前一个元素 visited == false
      ![剪枝2](https://github.com/bowen-wu/leetcode-solution/blob/master/src/main/java/com/leetcode/solution/backtracking/permutationsII/%E5%89%AA%E6%9E%9D2.png)
8. 如何分解子问题到下一层 => for loop
9. 如何回溯 => 删除单一解的最后一个元素
