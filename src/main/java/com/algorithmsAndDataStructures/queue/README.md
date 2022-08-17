# 队列 Queue

## 初始化

```
Queue<Integer> queue = new LinkedList<>();
```

## 基本操作

| 方法      | 参数      | 返回值          | 时间复杂度  |
|---------|---------|--------------|--------|
| offer   | Element | boolean/void | O(1)   |
| poll    | void    | Element      | O(1)   |
| peek    | void    | Element      | O(1)   |
| isEmpty | void    | boolean      | O(1)   |

## 使用场景

1. 广度优先搜索 BFS(Breadth-First Search)
2. 优先队列 Priority Queue(Heap)
3. 单调队列
4. 多任务调度
5. 消息队列
