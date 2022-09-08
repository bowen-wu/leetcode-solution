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

### 总结

| 问题行数 | 错误点                                                                                                       | 正确写法                                                                                                        | 错误原因                   |
|------|-----------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------|------------------------|
| 5    | if (s == null &#124;&#124; s.length == 0 &#124;&#124; wordDict == null &#124;&#124; wordDict.size() == 0) | if (s == null &#124;&#124; s.length() == 0 &#124;&#124; wordDict == null &#124;&#124; wordDict.size() == 0) | s.length 是一个方法，不是属性。大意 |
| 26   | returm memo[position] == 1;                                                                               | return memo[position] == 1;                                                                                 | 大意                     |
| 13   | int[] memo = new int[];                                                                                   | int[] memo = new int[s.length()];                                                                           | 大意                     |

```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Ideas: backtracking + memory search
        // check input
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }

        // working with resource data => 1. sort(unique + compare)  2. set(unique + optimize find)  3. Duplicated work
        Set<String> set = new HashSet<>(wordDict);

        // construct memory search => int -> boolean => init -> -1 false -> 0 true -> 1
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return helper(memo, s, 0, set);
    }

    private boolean helper(int[] memo, String s, int position, Set<String> set) {
        // exit recursion
        if (position >= s.length()) {
            return true;
        }

        // hit cache -> care out of index when memo is array
        if (memo[position] != -1) {
            return memo[position] == 1;
        }

        // construct result => true
        // check [position, s.length() - 1] is result
        String str = s.substring(position);
        if (set.contains(str)) {
            return true;
        }

        // recursive decomposition sub problem to next level + pruning
        for (int i = s.length() - 1; i >= position; i--) {
            // stage result + pruning
            if (!set.contains(s.substring(position, i + 1))) {
                continue;
            }

            boolean next = helper(memo, s, i + 1, set);
            if (next) {
                memo[position] = 1;
                return true;
            }
        }

        memo[position] = 0;
        return false;
    }
}
```
