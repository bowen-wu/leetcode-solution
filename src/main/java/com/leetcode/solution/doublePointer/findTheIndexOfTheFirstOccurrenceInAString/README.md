## 找出字符串中第一个匹配项的下标

<https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/>

### 思路

1. Brute Force
2. Rabin–Karp => 使用 Hash 比较两个字符串，如果 hashcode 相等，那么再挨个匹配(hash 冲突) => 注意
    - **减去高位贡献的时候要 mod base**
    - **添加后面字符贡献的时候要先乘 r**
    - **match 的时候以 0 开始，source 计算偏移即可**

#### 优化

1. Brute Force => 遍历边界不用到 length，到 length1 - length2 + 1 即可
2. Brute Force => 不使用第三个指针 k，使用 i + j 代替 k

### 总结

1. Rabin-Karp
    1. 低位贡献 => ` haystack.charAt(i + nLen - 1) `
    2. 高位贡献 => ` high = (high * random) % mod; `
    3. 贡献移动
       => ` sourceHash = (((sourceHash - (<高位贡献> * haystack.charAt(i - 1)) % mod + mod) % mod) * random + <低位贡献>) % mod; `

```java
class Solution {
    public int strStr(String haystack, String needle) {
        // check input
        if (haystack == null || haystack.length() == 0 || needle == null || needle.length() > haystack.length()) {
            return -1;
        }

        int hLen = haystack.length();
        int nLen = needle.length();
        char firstChar = needle.charAt(0);
        for (int i = 0; i <= hLen - nLen; i++) {
            char ch = haystack.charAt(i);
            if (ch == firstChar && isMatch(haystack, i, needle, nLen)) {
                return i;
            }
        }

        return -1;
    }

    private int random = 31;
    private int mod = 999991;

    public int strStrForRabinKarp(String haystack, String needle) {
        // check input
        if (haystack == null || haystack.length() == 0 || needle == null || needle.length() > haystack.length()) {
            return -1;
        }

        int hLen = haystack.length();
        int nLen = needle.length();
        int targetHash = hash(needle);
        int high = 1;
        for (int i = 1; i < nLen; i++) {
            high = (high * random) % mod;
        }

        String firstStr = haystack.substring(0, nLen);
        int sourceHash = hash(firstStr);
        if (sourceHash == targetHash && isMatch(haystack, 0, needle, nLen)) {
            return 0;
        }

        for (int i = 1; i <= hLen - nLen; i++) {
            sourceHash = (((sourceHash - (high * haystack.charAt(i - 1)) % mod + mod) % mod) * random + haystack.charAt(i + nLen - 1)) % mod;

            if (sourceHash == targetHash && isMatch(haystack, i, needle, nLen)) {
                return i;
            }
        }

        return -1;
    }

    private int hash(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            result = (result * random + str.charAt(i)) % mod;
        }
        return result;
    }

    private boolean isMatch(String source, int start, String target, int len) {
        for (int i = 1; i < len; i++) {
            if (source.charAt(start + i) != target.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
```
