## 在排序数组中查找元素的第一个和最后一个位置

<https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/>

### 思路

1. case => [5, 7, 7, 8, 8, 8, 8, 10] => 8 => [3, 6]
2. 找第一个小的 => 7 => smallerIndex: 2
3. 找第一个大的 => 10 => greaterIndex: 7
4. result => [smallerIndex + 1, greaterIndex - 1]

#### 优化

模板可以找到最左侧的target，此时相等移动的是 end 指针。如果要找最右侧的 target，那么相等时移动 start 即可
