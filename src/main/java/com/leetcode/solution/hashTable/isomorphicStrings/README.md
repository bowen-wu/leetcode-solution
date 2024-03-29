## 同构字符串

<https://leetcode.cn/problems/isomorphic-strings/>

### 思路

1. map => s -> t
2. map 不含有 key，但是含有 value => return false

### 总结

1. 不一定 str 都是字母，不能使用数组代替 Map

```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        // check input
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() != t.length()) {
            return false;
        }

        // map => character -> character
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char first = s.charAt(i);
            char second = t.charAt(i);
            if (map.containsKey(first)) {
                // contains
                if (map.get(first) != second) {
                    return false;
                }
            } else if (map.containsValue(second)) {
                return false;
            } else {
                map.put(first, second);
            }
        }
        return true;
    }
}
```
