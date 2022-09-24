## 迷宫 II

<https://leetcode.cn/problems/the-maze-ii/>

### 思路

1. 使用记忆化搜索 => start -> (x, y) 最短距离
2. 何时 DFS 或 offer => 记忆值比当前移动的步数大时

#### DFS

#### BFS

### 总结

1. 思路 => 使用 memory search 记录 start 到 (x, y) 的最短距离，移动到新位置后如果新位置的 memory search 的值比当前移动的距离大，则更新新位置的 memory search，之后继续 dfs or bfs
