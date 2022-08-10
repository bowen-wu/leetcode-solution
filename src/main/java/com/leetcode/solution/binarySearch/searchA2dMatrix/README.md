## 搜索二维矩阵

<https://leetcode.cn/problems/search-a-2d-matrix/>

### 思路

先判断第一列和 target 做二分查找，之后分为5种情况

- start > target => false
- start = target => true
- start < target < end => 在 start 行中二分查找
- target = end => true
- target > end => 在 end 行中二分查找

#### 优化

能否使用一次二分查找 => 将二维矩阵摊开，即如何根据位置确定坐标

- start = 0, end = m * n
- mid = start + (end - start) / 2 => 找坐标
    1. row => mid % (每行个数) == 0 ? (mid / (每行个数)) : (mid / (每行个数) + 1
    2. col => mid - (每行个数) * (row - 1) - 1
