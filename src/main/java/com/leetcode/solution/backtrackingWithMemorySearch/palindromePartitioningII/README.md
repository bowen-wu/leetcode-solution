## 分割回文串 II

<https://leetcode.cn/problems/palindrome-partitioning-ii/>

### 思路

1. 找到所有的分割，list.size() - 1 最小的返回
2. 设置一个全局变量，如果当前分割比全局变量小则更新全局变量，如果当前分割比全局变量大，则放弃

#### 优化点

1. 如果当前的切割次数已经大于了 minCutNum，则放弃 => 当前切个次数使用**记忆化搜索**优化，获取值是 O(1) 的

### 总结

| 问题行数 | 错误点                    | 正确写法                   | 错误原因   |
|------|------------------------|------------------------|--------|
| 14   | Arrays.fill(-1, memo); | Arrays.fill(memo, -1); | API 不熟 |

```java
class Solution {
    public int minCut(String s) {
        // Ideas: backtracking + memory search
        // check input
        if (s == null || s.length() == 0) {
            return 0;
        }

        // working with resource data => 1. sort(unique + compare)  2. set(unique + optimize find)  3. Duplicated work
        boolean[][] isValidPalindrome = checkIsValidPalindrome(s);

        // construct memory search => int -> int => init -1
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return helper(memo, s, 0, isValidPalindrome) - 1;
    }

    private int helper(int[] memo, String s, int position, boolean[][] isValidPalindrome) {
        // exit recursion
        if (position >= s.length()) {
            return Integer.MIN_VALUE;
        }

        // hit cache => care out of index when memo is array
        if (memo[position] != -1) {
            return memo[position];
        }

        // construct result
        int result = Integer.MAX_VALUE;

        // check [position, s.length() - 1] is result
        if (isValidPalindrome[position][s.length() - 1]) {
            memo[position] = 1;
            return 1;
        }

        // recursive decomposition sub problem to next level + pruning
        for (int i = s.length() - 1; i >= position; i--) {
            // pruning
            if (!isValidPalindrome[position][i]) {
                continue;
            }

            // stage result => 1
            int next = helper(memo, s, i + 1, isValidPalindrome);
            result = next != Integer.MIN_VALUE ? Math.min(result, next + 1) : 1;
        }

        // update memory search
        memo[position] = result;
        return result;
    }

    private boolean[][] checkIsValidPalindrome(String s) {
        boolean[][] isValidPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isValidPalindrome[i][i] = true;
        }

        for (int i = 1; i < s.length(); i++) {
            isValidPalindrome[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
        }

        // third | third+
        for (int i = s.length() - 3; i >= 0; i--) {
            for (int j = i + 2; j < s.length(); j++) {
                isValidPalindrome[i][j] = isValidPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        return isValidPalindrome;
    }
}
```
