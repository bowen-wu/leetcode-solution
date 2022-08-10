## 寻找旋转排序数组中的最小值

<https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/>

### 思路

1. 暴力 => 一个for循环 => 时间复杂度：O(n)
2. 二分查找
    1. nums[start] < nums[end] => 没有旋转过 => min = nums[start]
    2. nums[start] > nums[end] => 旋转过，记最大值的 index = maxIndex
        1. mid 在 (start, maxIndex) => mid > start > end => target == min => start = mid
        2. mid 在 (maxIndex, end) => mid < end < start => end = mid
   
