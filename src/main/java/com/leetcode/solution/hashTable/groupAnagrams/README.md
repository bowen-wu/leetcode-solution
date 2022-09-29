## 字母异位词分组

<https://leetcode.cn/problems/group-anagrams/>

### 思路

1. 不同字母异位词的字母序是相同的
    1. 字母序 => map => 字母序 -> List<word>
    2. 时间复杂度：O(n * k * logk) => n 为 strs.length，k 是 strs 中的字符串的平均长度
      ```
      // 生成字母序
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String alphabeticalOrder = new String(chars);
      ```
2. 不同字母异位词中相同字母出现的次数是相同的
    1. 字母 + 出现次数 => key -> List<Word> => case: abcac => a2b1c2
    2. 使用长度为26的数组记录每个字母出现的次数
    3. 时间复杂度：O(n * (k + 26))

### 总结

| 问题行数 | 错误点                                 | 正确写法                                  | 错误原因             |
|------|-------------------------------------|---------------------------------------|------------------|
| 17   | return new ArrayList<>(map.values); | return new ArrayList<>(map.values()); | API 不熟           |
| 50   | -                                   | Arrays.fill(nums, 0);                 | 没有 reset nums。思路 |

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Ideas: 字母序
        // check input
        if (strs == null || strs.length == 0) {
            return null;
        }

        // map => 字母序 -> List<String>;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String strOrder = getOrder(str);
            List<String> list = map.getOrDefault(strOrder, new ArrayList<>());
            list.add(str);
            map.put(strOrder, list);
        }
        return new ArrayList<>(map.values());
    }

    private String getOrder(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // Ideas: 出现次数
        // check input
        if (strs == null || strs.length == 0) {
            return null;
        }

        // map => a1b2c1 -> List<String>
        Map<String, List<String>> map = new HashMap<>();
        int[] nums = new int[26];
        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                nums[str.charAt(i) - 'a'] += 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    sb.append((char) (i + 'a'));
                    sb.append(nums[i]);
                }
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(str);
            map.put(sb.toString(), list);
            Arrays.fill(nums, 0);
        }

        return new ArrayList<>(map.values());
    }
}
```
