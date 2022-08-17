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

### 总结

| 问题行数 | 错误点                            | 正确写法                         | 错误原因 |
|------|--------------------------------|------------------------------|------|
| 22   | end = matrix[0].length         | end = matrix[0].length - 1   | 大意   |
| 25   | matrix[rowNum][start] < target | matrix[rowNum][mid] < target | 大意   |

```java
// 两次二分
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 思路：先按第一列二分查找，确定行了之后，在这个行进行二分查找
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int start = 0;
        int end = matrix.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        int rowNum = matrix[end][0] > target ? start : end;
        start = 0;
        end = matrix[0].length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[rowNum][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return matrix[rowNum][start] == target || matrix[rowNum][end] == target;
    }
}
```
