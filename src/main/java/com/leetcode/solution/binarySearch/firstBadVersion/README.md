## 第一个错误的版本

<https://leetcode.cn/problems/first-bad-version/>

### 思路

1. 二分查找
2. 找到第一个 isBadVersion == true
3. 数组形式 => [GGGGGBBBBBBB]
4. start 是 Good, end 是 Bad
5. mid
    1. is Bad => end = mid
    2. is Good => start = mid
