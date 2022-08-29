## 复原 IP 地址

<https://leetcode.cn/problems/restore-ip-addresses/>

### 思路

回溯法 => 排序问题 => 获取所有元素

1. 是否需要排序 => 不需要
2. 是否需要元素位置索引 => 不需要
3. helper 函数定义 => ` void helper(List<List<Integer>> result, List<Integer> list, String s) `
4. 单一解 => list.add(s.subString(len))
5. 递归何时退出 => s.length == 0
6. 单一解何时加入解集 => s.length == 0 && list.size() == 4
7. 剪枝 => s 逐步递减
    1. len > s.length
    2. len > 1 && s.subString(0, len).startWith("0")
    3. Integer.parseInt(s.subString(0, len)) > 255
    4. 至多 => s.length() > 3 * (4 - list.size())
    5. 至少 => s.length() < 1 * (4 - list.size())
8. 如何分解子问题到下一层 => for (int len = 1; len < 4; i++)
9. 如何回溯 => 删除单一解的最后一个元素

#### 优化

1. 单一解加入解集时 join
