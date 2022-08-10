## 搜索插入位置

<https://leetcode.cn/problems/search-insert-position/>

### 思路

二分查找

- 如果找到了，返回index
- 如果没找到，返回第一个大的元素的 index
- 如果 end < target，则返回 end + 1

#### 优化

- 找到第一个大于等于 target 的 index

```
if (target == nums[start]) {
    return start;
}
if (target == nums[end]) {
    return end;
}
if (target < nums[start]) {
    return start;
}
if (target < nums[end]) {
    return end;
}
if (target > nums[end]) {
    return end + 1;
}
return -1;

// 优化为：
if (nums[start] >= target) {
    return start;
} else if (nums[end] >= target) {
    return end;
} else {
    return end + 1;
}
```
