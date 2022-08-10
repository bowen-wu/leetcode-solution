## 搜索二维矩阵 II

<https://leetcode.cn/problems/search-a-2d-matrix-ii/>

### 思路

1. 暴力 => 两层 for loop => 时间复杂度: O(m * n)
2. 对每一行二分查找 => 时间复杂度: O(mlogn)
3. 右上角 => 最小行，最大列
    - 向左递减
    - 向下递增
    - 如果 target < 右上角 => 向左移动
    - 如果 target > 右上角 => 向下移动
4. 左下角 => 最大行，最小列
    - 向上递减
    - 向右递增
    - 如果 target < 左下角 => 向上移动
    - 如果 target > 左下角 => 向右移动

**构造单调有序性**
