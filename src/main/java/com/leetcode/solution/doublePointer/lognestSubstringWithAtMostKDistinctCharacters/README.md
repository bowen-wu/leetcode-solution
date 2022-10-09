## 至多包含 K 个不同字符的最长子串

<https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/>

### 思路

- sidling window
- map => char -> last index
- 如何扩展 => 
   1. map 中包含的字符小于k个
   2. map 中的字符是k个，但是现在的字符在 map 中
- 如何收窄 => 找到 map 中最小的 index，让 i 移动到 minIndex
