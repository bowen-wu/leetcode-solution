## 至多包含两个不同字符的最长子串

<https://leetcode.cn/problems/longest-substring-with-at-most-two-distinct-characters/>

### 思路

- 滑动窗口
- map => char -> 最后出现的位置
- 如何扩展 =>
   1. map 里面有 0 或 1 个元素
   2. map 里面有 2 个元素了，但是当前字符也在 map 中
- 如何收缩 => 在 map 中找到最小的 index，i 移动到 minIndex

### 总结

| 问题行数    | 错误点                                   | 正确写法 | 错误原因                   |
|---------|---------------------------------------|------|------------------------|
| 27 - 31 | map.merge(removeCh, -1, Integer::sum) | -    | 收窄的时候如果是 1，则 remove。边界 |

```java
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap();
        int len = s.length();
        int j = 0;
        int result = 0;
        for (int i = 0; i < len; i++) {
            while (j < len) {
                char ch = s.charAt(j);
                if (map.containsKey(ch) || map.size() < 2) {
                    map.merge(ch, 1, Integer::sum);
                    j++;
                } else {
                    break;
                }
            }

            if (result < j - i) {
                result = j - i;
            }

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
