## 有效的字母异位词

<https://leetcode.cn/problems/valid-anagram/>

### 思路

1. 遍历第一个记录出现的次数
2. 遍历第二个减去出现的次数
3. 查看是否有不是0的

#### 优化

1. 减去的时候如果是0了，直接 remove，最终查看 size == 0
2. 使用数组存储 => ch - 'a' => 数组长度为 26
3. 减的时候判断是否小于0可以代替最后一次遍历是否等于0

### 总结

| 问题行数 | 错误点                                                     | 正确写法                                                        | 错误原因 |
|------|---------------------------------------------------------|-------------------------------------------------------------|------|
| 39   | map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)); | map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1); | 大意   |
| 13   | map[s.charAt[i] - 'a'] += 1;                            | map[s.charAt(i) - 'a'] += 1;                                | 大意   |
| 21   | map[ch - 'a'] -= 0;                                     | map[ch - 'a'] -= 1;                                         | 大意   |

```java
class Solution {
    public boolean isAnagram(String s, String t) {
		// Ideas: 1. 字母序 equals 2. 出现次数相同
		// check input
		if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() != t.length()) {
			return false;
		}

		// map => char -> value => char - 'a' => int -> value
		int[] map = new int[26];

		for (int i = 0; i < s.length(); i++) {
			map[s.charAt(i) - 'a'] += 1;
		}

		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			if (map[ch - 'a'] == 0) {
				return false;
			} else {
				map[ch - 'a'] -= 1;
			}
		}

		return true;
	}

    public boolean isAnagramWithMap(String s, String t) {
        // Ideas: 1. 字母序 equals 2. 出现次数相同
        // check input
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() != t.length()) {
            return false;
        }

        // map => char -> value
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch)) {
                int newNum = map.get(ch) - 1;
                if (newNum == 0) {
                    map.remove(ch);
                } else {
                    map.put(ch, newNum);
                }
            } else {
                return false;
            }
        }

        return map.isEmpty();
    }
}
```
