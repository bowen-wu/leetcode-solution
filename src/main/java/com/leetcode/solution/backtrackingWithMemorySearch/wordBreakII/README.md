## 单词拆分 II

<https://leetcode.cn/problems/word-break-ii/>

### 思路

回溯法 => 排列问题

1. 是否需要排序 => 不需要
2. 是否需要元素位置索引 => 需要
3. helper 函数定义
   => ` void helper(List<String> result, StringBuffer stringBuffer, String s, int position, Set<String> set) `
4. 递归何时推出 => position >= s.length()
5. 单一解何时加入解集 => position == s.length()
6. 剪枝
7. 递归分解子问题到下一层 => for (int i = position; i < s.length(); i++)
8. 如何回溯 => 单一解删除最后一个元素

#### 优化

1. 记忆化搜索

