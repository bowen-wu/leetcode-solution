## 最小覆盖子串

<https://leetcode.cn/problems/minimum-window-substring/>

### 思路

- sidling window
- map => 统计 t 中字符个数
- 如何扩展 => 没找全时 => 字符 + 次数
- 如何收窄 => 如果 i 位置对应的字符在 map 中，那么 ++
- 如何更新结果 =>
    1. 全部找到
    2. 当前长度比 minLength 短

#### 优化

1. 使用 128 的数组优化 map

### 总结

| 问题行数 | 错误点                             | 正确写法                        | 错误原因              |
|------|---------------------------------|-----------------------------|-------------------|
| 32   | -                               | resultLen = j - i;          | 没有更新 resultLen。大意 |
| 33   | result = s.substring(i, j + 1); | result = s.substring(i, j); | 边界问题              |

```java
class Solution {
    public String minWindow(String s, String t) {
        // check input
        if (s == null || s.length() == 0 || t == null || t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.merge(t.charAt(i), 1, Integer::sum);
        }

        int resultLen = Integer.MAX_VALUE;
        String result = "";
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                // 扩展 => map 中的每个值都大于0
                if (expandable(map)) {
                    char ch = s.charAt(j);
                    if (map.containsKey(ch)) {
                        map.merge(ch, -1, Integer::sum);
                    }
                    j++;
                } else {
                    break;
                }
            }

            // 收窄 + update
            if (!expandable(map) && (j - i < resultLen)) {
                resultLen = j - i;
                result = s.substring(i, j);
            }
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.merge(ch, 1, Integer::sum);
            }
        }

        return result;
    }


    private boolean expandable(Map<Character, Integer> map) {
        for (int num : map.values()) {
            if (num > 0) {
                return true;
            }
        }
        return false;
    }

    public String minWindowWithArray(String s, String t) {
        // check input
        if (s == null || s.length() == 0 || t == null || t.length() > s.length()) {
            return "";
        }

        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)] += 1;
        }

        int resultLen = Integer.MAX_VALUE;
        String result = "";
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                // 扩展 => map 中的每个值都大于0
                if (!allFound(map)) {
                    char ch = s.charAt(j);
                    map[ch] -= 1;
                    j++;
                } else {
                    break;
                }
            }

            // 收窄 + update
            if (allFound(map) && (j - i < resultLen)) {
                resultLen = j - i;
                result = s.substring(i, j);
            }
            map[s.charAt(i)] += 1;
        }

        return result;
    }

    private boolean allFound(int[] map) {
        for (int num : map) {
            if (num > 0) {
                return false;
            }
        }
        return true;
    }
}
```
