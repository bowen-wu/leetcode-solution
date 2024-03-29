## 单词规律

<https://leetcode.cn/problems/word-pattern/>

### 思路

1. map => pattern char -> word
2. 遍历 pattern
3. s 不能有剩余

#### 优化

1. 使用数组存储 s 的 word

### 总结

| 问题行数    | 错误点 | 正确写法 | 错误原因                                           |
|---------|-----|------|------------------------------------------------|
| 22 - 24 | -   | -    | 需要判断该值是否已经在 map 中，case：abba -> dog dog dog dog |

```java
class Solution {
    public boolean wordPattern(String pattern, String s) {
        // Ideas: Hash table
        // check input
        if (pattern == null || pattern.length() == 0 || s == null || s.length() == 0) {
            return true;
        }

        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) {
            return false;
        }

        // map => char -> String
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(strings[i])) {
                    return false;
                }
            } else if (map.containsValue(strings[i])) {
                return false;
            } else {
                map.put(ch, strings[i]);
            }
        }

        return true;
    }
}
```
