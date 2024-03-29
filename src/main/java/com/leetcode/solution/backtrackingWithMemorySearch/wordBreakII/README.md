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

### 总结

| 问题行数 | 错误点                                             | 正确写法                                             | 错误原因       |
|------|-------------------------------------------------|--------------------------------------------------|------------|
| 46   | if (int i = s.length() - 1; i >= position; i--) | for (int i = s.length() - 1; i >= position; i--) | 笔误         |
| 14   | return false;                                   | return new ArrayList<>()                         | 如何没有返回空。大意 |
| 53   | List<String> next = help(memo, s, i + 1, set);  | List<String> next = helper(memo, s, i + 1, set); | 大意         |
| 62   | memo[position] = result;                        | memo.put(position, result);                      | 大意         |

```java
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // Ideas: backtracking + memory search
        // 1. is need sort => no
        // 2. is need element index => yes
        // 3. helper => List<String> helper(Map<Integer, List<String>> memo, String s, int position, Set<String> set)
        // 4. when exit recursion => position >= s.length()
        // 5. when single result add to solution set => no
        // 6. pruning => hit cache
        // 7. recursive decomposition sub problem to next level => for loop => s.length() - 1 -> position
        // 8. how to backtracking
        // check input
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return new ArrayList<>();
        }

        // working with resource data => 1. Sort(重复 + 比较大小) 2. Set(优化查找) 3. Duplicate Word
        Set<String> set = new HashSet<>(wordDict);

        // construct memory search
        Map<Integer, List<String>> memo = new HashMap<>();
        return helper(memo, s, 0, set);
    }

    private List<String> helper(Map<Integer, List<String>> memo, String s, int position, Set<String> set) {
        // hit cache => care out of index if memo is array
        if (memo.containsKey(position)) {
            return memo.get(position);
        }

        // construct result
        List<String> result = new ArrayList<>();

        // exit recursion
        if (position >= s.length()) {
            return result;
        }

        // check [position, s.length() - 1] is result
        String str = s.substring(position);
        if (set.contains(str)) {
            result.add(str);
        }

        // recursive decomposition sub problem to next level
        for (int i = s.length() - 1; i >= position; i--) {
            String substring = s.substring(position, i + 1);
            if (!set.contains(substring)) {
                // pruning
                continue;
            }

            List<String> next = helper(memo, s, i + 1, set);

            // construct single result and add to result
            for (String item : next) {
                result.add(substring + " " + item);
            }
        }

        // update memo
        memo.put(position, result);
        return result;
    }
}
```
