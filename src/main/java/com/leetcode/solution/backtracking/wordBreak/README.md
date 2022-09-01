## 单词拆分

<https://leetcode.cn/problems/word-break/>

### 思路

回溯法 => 组合问题

1. 是否需要排序 => 不需要
2. 是否需要元素位置索引 => 需要
3. helper 函数定义
   => ` void helper(List<List<String>> result, List<String> list, String s, List<String> wordDict, int position) `
4. 递归何时退出 => position >= s.length
5. 单一解何时加入解集 => position == s.length
6. 剪枝
    1. 当前 substring 不在字典中就不 add 到单一解中
7. 如何分解子问题到下一层 => for loop
8. 如何回溯 => 单一解删除最后一个元素
9. 超出时间限制

#### 优化

1. 使用 Set 优化查找 substring
2. 先判断长的，再判断短的 => case: leetcode => leetcode + leetcod + leetco + ...
3. aaaaaaaaa => 有重复查找 => 记忆化搜索
