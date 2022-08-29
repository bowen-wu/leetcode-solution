## 二叉树的所有路径

<https://leetcode.cn/problems/binary-tree-paths/>

### 思路

回溯 => 排列问题 => 所有元素

1. 是否需要排序 => 不需要
2. 是否需要元素位置索引 => 不需要
3. helper 函数定义 => ` void helper(List<String> result, List<String> list, TreeNode node) `
4. 递归退出条件 => node is leaf
5. 单一解何时加入解集 => node is leaf
6. 剪枝 => 无
7. 递归分解子问题到下一层 =>
8. 如何回溯 => 单一解删除最后一个元素

#### 优化

1. helper 函数刚刚进入的时候就把 node.val 加入到单一解中
