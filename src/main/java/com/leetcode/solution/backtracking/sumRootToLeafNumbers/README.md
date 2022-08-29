## 求根节点到叶节点数字之和

<https://leetcode.cn/problems/sum-root-to-leaf-numbers/>

### 思路

回溯法 => 组合问题 => 查找所有元素

1. 是否需要排序 => 不需要
2. 是否需要元素位置索引 => 不需要
3. helper 函数定义 => ` void helper(int result, List<Integer> list, TreeNode node) `
4. 递归何时退出 => node is leaf
5. 单一解何时加入解集中 => node is leaf
6. 剪枝
7. 递归分解子问题到下一层 => node.left + node.right
8. 如何回溯 => 单一解删除最后一个元素
