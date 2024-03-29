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

### 总结

| 问题行数 | 错误点                     | 正确写法                                | 错误原因                                                          |
|------|-------------------------|-------------------------------------|---------------------------------------------------------------|
| 39   | if (rightRemaining > 0) | if (rightRemaining > leftRemaining) | 思路问题，此处需要 rightRemaining > leftRemaining 才能推出右括号，并且此时**无需剪枝** |

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        // Ideas: backtracking => 排列问题
        // 1. Is need sort => no
        // 2. Is need element index => no
        // 3. helper => void helper(List<String> result, StringBuffer stringBuffer, int leftRemaining, int rightRemaining)	
        // 4. when exit recursion => leftRemaining == 0 && rightRemaining == 0
        // 5. when single result add to solution set => leftRemaining == 0 && rightRemaining == 0
        // 6. pruning => no
        // 7. recursive decomposition subproblem to next level => for loop
        // 8. how to backtracking => delete single result last element
        // solution set
        List<String> result = new ArrayList<>();

        // check input
        if (n < 1) {
            return result;
        }

        // single result + calculate solution set
        StringBuffer stringBuffer = new StringBuffer();
        helper(result, stringBuffer, n, n);
        return result;
    }

    private void helper(List<String> result, StringBuffer stringBuffer, int leftRemaining, int rightRemaining) {
        // exit recursion + single result add to solution set
        if (leftRemaining == 0 && rightRemaining == 0) {
            result.add(stringBuffer.toString());
            return;
        }

        if (leftRemaining > 0) {
            stringBuffer.append("(");
            helper(result, stringBuffer, leftRemaining - 1, rightRemaining);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }

        if (rightRemaining > leftRemaining) {
            stringBuffer.append(")");
            helper(result, stringBuffer, leftRemaining, rightRemaining - 1);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }
}
```
