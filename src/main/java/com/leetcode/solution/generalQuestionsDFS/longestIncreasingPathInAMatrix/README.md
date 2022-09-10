## 矩阵中的最长递增路径

<https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/>

### 思路

1. 递增 => 下一个数字需要大于当前数字
2. 向四个方向做任意移动
3. DFS => 可以在 memory search =>
    1. init 0
    2. cannot move -1
    3. can move > 0
