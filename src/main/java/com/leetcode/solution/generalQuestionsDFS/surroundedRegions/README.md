## 被围绕的区域

<https://leetcode.cn/problems/surrounded-regions/>

### 思路

二维矩阵 DFS => 连通分量

1. 求得所有的 O 的 List => O 不能连接边界 => 超时

#### 优化

1. 从边界 O 开始 DFS 计算连通分量 => O 不变 => 
2. 边界 O 开始的连通分量的 O 先变为 B
3. 把其余的 O 变为 X
4. 把 B 变为 O
