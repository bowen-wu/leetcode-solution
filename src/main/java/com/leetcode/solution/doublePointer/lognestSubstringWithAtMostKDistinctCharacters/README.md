## 至多包含 K 个不同字符的最长子串

<https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/>

### 思路

- sidling window
- map => char -> last index
- 如何扩展 =>
    1. map 中包含的字符小于k个
    2. map 中的字符是k个，但是现在的字符在 map 中
- 如何收窄 => 找到 map 中最小的 index，让 i 移动到 minIndex

### 总结

| 问题行数 | 错误点                   | 正确写法                  | 错误原因 |
|------|-----------------------|-----------------------|------|
| 13   | char ch = s.charAt(i) | char ch = s.charAt(j) | 大意   |

```java
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // check input
        if (s == null || s.length() == 0 || k < 1) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                char ch = s.charAt(j);
                if (map.size() < k || (map.size() == k && map.containsKey(ch))) {
                    map.merge(ch, 1, Integer::sum);
                    j++;
                } else {
                    break;
                }
            }

            result = Math.max(result, j - i);
            char removeCh = s.charAt(i);
            if (map.get(removeCh) == 1) {
                map.remove(removeCh);
            } else {
                map.merge(removeCh, -1, Integer::sum);
            }
        }

        return result;
    }
}
```
