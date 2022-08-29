## 电话号码的字母组合

<https://leetcode.cn/problems/letter-combinations-of-a-phone-number/>

### 思路

回溯法 => 组合问题 => 挑选全部元素

1. 是否需要排序 => 不需要
2. 是否需要元素位置索引 => 需要
3. helper 函数定义 => ` void helper(List<String> result, List<String> list, String digits, int position) `
4. 递归何时退出 => position == digits.length()
5. 单一解何时加入解集 => position == digits.length()
6. 剪枝 => 无
7. 如何分解子问题到下一层 => for(int i = 0; i < map.get(digits[position]).length(); i++)
8. 如何回溯 => 单一解删除最后一个元素

#### 优化

1. position 可是使用 list 的 size 代替
