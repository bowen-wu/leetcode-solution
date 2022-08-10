## 总结

https://leetcode.cn/problems/range-sum-query-2d-immutable/

```java
class NumMatrix {
    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        // 思路：数组前缀和
        // 时间复杂度：O(m * n)
        // 空间复杂度：O(m * n)
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new RuntimeException("The matrix is invalid!");
        }

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        prefixSum = new int[rowLength + 1][colLength + 1];
        // prefixSum[i + 1][j + 1] 表示 [0][0] 到[i][j] 的面积
        // prefixSum[row][col] = prefixSum[row - 1][col] + prefixSum[row][col - 1] - prefixSum[row - 1][col - 1] + matrix[row][col]
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                prefixSum[row + 1][col + 1] = prefixSum[row][col + 1] + prefixSum[row + 1][col] - prefixSum[row][col] + matrix[row][col];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 时间复杂度：O(1)
        return prefixSum[row2 + 1][col2 + 1] - prefixSum[row1][col2 + 1] - prefixSum[row2 + 1][col1] + prefixSum[row1][col1];
    }
}
```

| 问题行数 | 错误点            | 正确写法             | 错误原因       |
|------|----------------|------------------|------------|
| 17   | for (row = 0   | for (int row = 0 | 没有写 int，大意 |
| 18   | for (col= 0    | for (int col= 0  | 没有写 int，大意 |
| 8    | -              | -                | 最后一个 { 没有写 |
| 17   | for (int i = 1 | for (int i = 0   | 初始值应该是0    |
| 18   | for (int j = 1 | for (int j = 0   | 初始值应该是0    |
