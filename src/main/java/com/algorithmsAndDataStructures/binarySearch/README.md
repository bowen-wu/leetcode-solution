# BinarySearch

## 概述

- 将目标值与数组的中间元素进行比较
- 如果数组为空，则代表找不到
- 每一次比较都使搜索范围缩小一半
- 在**排序数组**中搜索的最快方法

## 模板

```java
public class BinarySearch {
    public int binarySearch(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) { // 相邻即退出
            int mid = start + (end - start) / 2; // 可以防止两个整型值相加时溢出
            if (target > nums[mid]) { // 如果数组中有多个 target，此时找到的是最左侧的，即相等时移动的是 end。如果要找最右侧的，那么相等时移动 start 即可
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
```

```javascript
const binarySearch = (nums, target) => {
  if (nums == null || nums.length == 0) {
    return -1;
  }

  let start = 0;
  let end = nums.length - 1;
  while (start + 1 < end) {
    let mid = Math.floor((start + end) / 2);
    if (target > nums[mid]) {
      start = mid;
    } else {
      end = mid;
    }
  }

  if (nums[start] == target) {
    return start;
  }
  if (nums[end] == target) {
    return end;
  }
  return -1;
}
```

### 模板变化

- 查找第一个 => 左边界 => end = mid
- 查找最后一个 => 右边界 => start = mid
- 找区间 => 两次找即可

## 时间复杂度

- T(n) = T(n/2) + m
- 主定理 => a = 1, b = 2, c = 0
- log<sub>b</sub>a = 0 == c
- T(n) = O(n<sup>c</sup>logn) = O(logn)

## 数组区间有序地二分问题

- 数组不是完全有序，但仍能找到部分有序的空间
- **根据判断，去掉没有解的一半** => 通过比较关键点大小知道哪一半可以不要
- 比较 nums[start], nums[mid] 和 nums[end] 的大小去丢弃，查看目标值是在 (start, mid) 还是在 (mid, end) 区间

## 知识点

1. 一维坐标 index 和二维矩阵坐标(x, y)相互转换
    - x = index / (列数)
    - y = index % (列数)
    - index = x * n + y
