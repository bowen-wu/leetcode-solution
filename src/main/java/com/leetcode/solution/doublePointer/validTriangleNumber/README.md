## 有效三角形的个数

<https://leetcode.cn/problems/valid-triangle-number/>

### 思路

1. a + b > c => a + b == 两数之和
2. target 相当于第三边 => Two-Sum 大于 target 的个数 => target 从后往前取
