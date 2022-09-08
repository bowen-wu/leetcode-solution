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

### 总结

1. position 使用 stringBuffer.length() 代替

| 问题行数 | 错误点                                                | 正确写法                                                  | 错误原因                              |
|------|----------------------------------------------------|-------------------------------------------------------|-----------------------------------|
| 15   | NullPointerException                               | -                                                     | map 未初始化                          |
| 48   | int i = position                                   | int i = 0                                             | 遍历时初始值应该是 0。边界问题                  |
| 50   | helper(result, stringBuffer, digits, i + 1);       | helper(result, stringBuffer, digits, position + 1);   | 应该传入下一层的初始值，应该是 position + 1。边界问题 |
| 28   | if (digits == 0 &#124;&#124; digits.length() == 0) | if (digits == null &#124;&#124; digits.length() == 0) | 笔误                                |
| 48   | i < list.length()                                  | i < list.size()                                       | 遍历时初始值应该是 0。边界问题                  |

```java
class Solution {
    private Map<Character, List<Character>> map;

    public List<String> letterCombinations(String digits) {
        // Ideas: backtracking => 排列问题
        // 1. 是否需要排序 => 不需要
        // 2. 是否需要元素位置 => 需要
        // 3. helper 函数定义 => void helper(List<String> result, StringBuffer stringBuffer, String digits, int position)
        // 4. 递归何时退出 => position >= digits.length()
        // 5. 单一解何时加入解集 => position >= digits.length()
        // 6. 剪枝
        // 7. 如何分解子问题到下一层 => for loop
        // 8. 如何回溯 => 单一解删除最后一个元素
        // 9. 优化 => position 可以使用 stringBuffer 的 length 代替
        map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        // 解集
        List<String> result = new ArrayList<>();

        // check input
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // 单一解 + 计算解集 => 单一解加入解集中
        StringBuffer stringBuffer = new StringBuffer();
        helper(result, stringBuffer, digits);
        return result;
    }

    private void helper(List<String> result, StringBuffer stringBuffer, String digits) {
        // 递归何时退出 + 单一解加入解集中
        if (stringBuffer.length() >= digits.length()) {
            result.add(stringBuffer.toString());
            return;
        }

        // 递归分解子问题到下一层 + 剪枝
        List<Character> list = map.get(digits.charAt(stringBuffer.length()));
        for (int i = 0; i < list.size(); i++) {
            stringBuffer.append(list.get(i));
            helper(result, stringBuffer, digits);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }
}
```
