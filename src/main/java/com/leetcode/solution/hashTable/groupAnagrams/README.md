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
