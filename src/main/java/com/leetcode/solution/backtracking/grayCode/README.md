## 格雷编码

<https://leetcode.cn/problems/gray-code/>

### 思路

回溯法 => 排列 => 任一结果

1. 是否需要排序 => 不需要
2. 是否需要元素索引 => 不需要
3. helper 函数定义 => ` void helper(List<Integer> result, List<Integer> list, int[] nums) `
4. 递归何时退出 => 找到一个结果
5. 单一解何时加入解集 => list.size() == nums.length && isValid
6. 剪枝 => 找到一个结果就退出
7. 如何分解子问题到下一层 => for => 注意一个数字只能使用一次
8. 如何回溯 => 单一解删除最后一个元素
9. cast: n = 2 => 使用 0 1 2 3 构建解空间树
   ![构建解空间树](https://github.com/bowen-wu/leetcode-solution/blob/master/src/main/java/com/leetcode/solution/backtracking/grayCode/%E8%A7%A3%E7%A9%BA%E9%97%B4%E6%A0%91.png)

#### 优化

1. 使用 0 1 构建解空间树 => 永远只有两个分支 => 单一解就是一个数字
