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

### 总结

| 问题行数 | 错误点                                                          | 正确写法                                                         | 错误原因 |
|------|--------------------------------------------------------------|--------------------------------------------------------------|------|
| 24   | Map<Integer, List<List<String>>> memo = new ArrayList<>();   | Map<Integer, List<List<String>>> memo = new HashMap<>();     | 笔误   |
| 44   | result.add(s.substring(position));                           | result.add(Arrays.asList(s.substring(position)));            | 大意   |
| 83   | for (j = i + 2;                                              | for (int j = i + 2;                                          | 大意   |
| 35   | List<List<String>> result = new ArryList<>();                | List<List<String>> result = new ArrayList<>();               | 大意   |
| 44   | result.add(Collections.singleList(s.substring(position)))    | result.add(Collections.singletonList(s.substring(position))) | 大意   |
| 78   | isValidPalindrome[i - 1][i] = s.charAt(i - 1) == a.charAt(i) | isValidPalindrome[i - 1][i] = s.charAt(i - 1) == s.charAt(i) | 大意   |
| 88   | miss return                                                  | return isValidPalindrome;                                    | 大意   |

```java
class Solution {
    public List<List<String>> partition(String s) {
        // Ideas: backtracking + memory search
        // 1. is need sort => no
        // 2. is need element index => yes
        // 3. helper => List<List<String>> helper(Map<Integer, List<String>> memo, String s, int position)
        // 4. when exit recursion => position >= s.length() 
        // 5. when single result add to solution set => 
        // 6. pruning
        //		1. hit cache => return cache 
        // 7. recursive decomposition sub problem to next level => for loop => s.length() - 1 -> position
        // 8. how to backtracking => 
        // 9. memory search => 1. isValidPalindrome + 2. split cache
        // check input
        if (s == null || s.length() == 0) {
            return null;
        }

        // working with source data => 1. sort(去重 + 比较大小) 2. set(优化查找) 3. 优化 Duplicate Work
        // 1. isValidPalindrome index i to index j is valid palindrome => range: [i, j]
        boolean[][] isValidPalindrome = checkIsValidPalindrome(s);

        // constructor memory search
        Map<Integer, List<List<String>>> memo = new HashMap<>();
        return helper(memo, s, 0, isValidPalindrome);
    }

    private List<List<String>> helper(Map<Integer, List<List<String>>> memo, String s, int position, boolean[][] isValidPalindrome) {
        // hit cache => care about out of index if memo is array
        if (memo.containsKey(position)) {
            return memo.get(position);
        }

        // constructe result
        List<List<String>> result = new ArrayList<>();

        // exit recursion
        if (position >= s.length()) {
            return result;
        }

        // is [position, s.length() - 1] result
        if (isValidPalindrome[position][s.length() - 1]) {
            result.add(Arrays.asList(s.substring(position)));
        }

        for (int i = s.length() - 1; i >= position; i--) {
            if (!isValidPalindrome[position][i]) {
                // pruning
                continue;
            }

            // 阶段性结果 => staged result
            String substring = s.substring(position, i + 1);
            List<List<String>> next = helper(memo, s, i + 1, isValidPalindrome);

            // constructe single result
            for (List<String> item : next) {
                List<String> singleResult = new ArrayList<>();
                singleResult.add(substring);
                singleResult.addAll(item);
                result.add(singleResult);
            }
        }

        // update memo
        memo.put(position, result);
        return result;
    }

    private boolean[][] checkIsValidPalindrome(String str) {
        boolean[][] isValidPalindrome = new boolean[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            isValidPalindrome[i][i] = true;
        }

        for (int i = 1; i < str.length(); i++) {
            isValidPalindrome[i - 1][i] = str.charAt(i - 1) == str.charAt(i);
        }

        // for third and third+ => from str.length() to 0
        for (int i = str.length() - 3; i >= 0; i--) {
            for (int j = i + 2; j < str.length(); j++) {
                isValidPalindrome[i][j] = isValidPalindrome[i + 1][j - 1] && str.charAt(i) == str.charAt(j);
            }
        }

        return isValidPalindrome;
    }
}
```
