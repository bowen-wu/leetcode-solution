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
