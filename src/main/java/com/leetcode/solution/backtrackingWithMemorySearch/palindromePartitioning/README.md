## 分割回文串

<https://leetcode.cn/problems/palindrome-partitioning/>

### 思路

回溯法 => 组合问题 => 所有元素

1. 是否需要排序 => 不需要
2. 是否需要元素位置索引 => 需要
3. helper 函数定义 => ` void helper(List<List<Integer>> result, List<Integer> list, String s, int position) `
4. 递归何时退出 => position >= s.length()
5. 单一解何时加入解集 => position == s.length() - 1
6. 剪枝 => 如果该 str 不是字符串
7. 递归分解子问题到下一层 => for(int i = 0; i < s.length(); i++)
8. 如何回溯 => 单一解删除最后一个元素

#### 优化

1. 判断是否是回文串是 Duplicate Work => 记忆化搜索
2. 分割 bbb 是 Duplicate Work => 记忆化搜索
