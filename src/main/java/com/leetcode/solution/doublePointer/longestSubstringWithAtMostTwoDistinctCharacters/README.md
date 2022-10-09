## 至多包含两个不同字符的最长子串

<https://leetcode.cn/problems/longest-substring-with-at-most-two-distinct-characters/>

### 思路

- 滑动窗口
- map => char -> 最后出现的位置
- 如何扩展 =>
   1. map 里面有 0 或 1 个元素
   2. map 里面有 2 个元素了，但是当前字符也在 map 中
- 如何收缩 => 在 map 中找到最小的 index，i 移动到 minIndex
