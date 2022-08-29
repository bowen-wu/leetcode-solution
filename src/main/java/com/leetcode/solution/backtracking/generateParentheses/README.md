## 括号生成

<https://leetcode.cn/problems/generate-parentheses/>

### 思路

回溯 => 组合问题 => 全选

1. 是否需要排序 => 不需要
2. 是否需要元素位置索引 => 不需要
3. helper 函数定义 => ` void helper(List<String> result, List<String> list, int n, int left, int right) `
5. 递归何时退出 => list.size() == n * 2
6. 单一解何时加入解集 => isValidParentheses && list.size() == n * 2
7. 剪枝 => left > right
8. 如何递归子问题到下一层 => for loop
9. 如何回溯 => 单一解移除最后一个元素
