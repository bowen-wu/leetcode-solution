## 省份数量

<https://leetcode.cn/problems/number-of-provinces/>

### 思路

1. 求连通分量 => dfs 次数
2. 判断是否连接 => ` isConnect[start][i] == 1 `
    1. 连接 => 继续 dfs 遍历
    2. 不连接 => 跳过
