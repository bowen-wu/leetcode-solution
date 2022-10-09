## 最小覆盖子串

<https://leetcode.cn/problems/minimum-window-substring/>

### 思路

- sidling window
- map => 统计 t 中字符个数
- 如何扩展 => 没找全时 => 字符 + 次数
- 如何收窄 => 如果 i 位置对应的字符在 map 中，那么 ++
- 如何更新结果 =>
    1. 全部找到
    2. 当前长度比 minLength 短

#### 优化

1. 使用 128 的数组优化 map
