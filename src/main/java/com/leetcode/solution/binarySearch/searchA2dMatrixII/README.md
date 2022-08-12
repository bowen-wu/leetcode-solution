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

### 总结

| 问题行数 | 错误点                      | 正确写法                         | 错误原因 |
|------|--------------------------|------------------------------|------|
| 9    | int y = matrix[0].length | int y = matrix[0].length - 1 | 大意   |

```java
class Solution {
    // 思路：选取右上角做为切入点，右上角特性，向左依次递减，向下依次递增
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int x = 0;
        int y = matrix[0].length - 1;

        while (x < matrix.length && y >= 0) {
            if (target > matrix[x][y]) {
                x++;
            } else if (target == matrix[x][y]) {
                return true;
            } else {
                y--;
            }
        }

        return false;
    }
}
```
